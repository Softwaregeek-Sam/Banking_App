package dev.sumit.bank_app.user.auth;


import dev.sumit.bank_app.bankingcore.Account;
import dev.sumit.bank_app.config.JwtService;
import dev.sumit.bank_app.dto.request.AuthenticationRequest;
import dev.sumit.bank_app.dto.request.RegisterRequest;
import dev.sumit.bank_app.dto.response.AuthenticationResponse;
import dev.sumit.bank_app.dto.response.RegistrationResponse;
import dev.sumit.bank_app.user.Role;
import dev.sumit.bank_app.user.User;
import dev.sumit.bank_app.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        // Check if user is soft-deleted
        if (user.isDeleted()) {
            throw new RuntimeException("The user is deleted and cannot be authenticated.");
        }
        var jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .firstName(user.getFirstname())
                    .lastName(user.getLastname())
                    .id(String.valueOf(user.getId()))
                    .email(user.getEmail())
                    .role( user.getRole())
                    .build();

    }

    @Transactional
    public RegistrationResponse register(RegisterRequest request) {
        if(!repository.existsByEmail(request.getEmail())){
            Role userRole = Role.USER;

            if(request.getRole() != null && request.getRole().equals("ADMIN")) {
                userRole = Role.ADMIN;
            }

            User user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(userRole)
                    .build();

            Account newAccount = new Account();
            newAccount.setBalance(new BigDecimal("0.00"));

            newAccount.setUser(user);
            user.getAccountList().add(newAccount);

            User savedUser = repository.save(user);

            return RegistrationResponse.builder()
                    .firstName(savedUser.getFirstname())
                    .id(String.valueOf(savedUser.getId()))
                    .email(savedUser.getEmail())
                    .role(userRole)
                    .build();
        }else return null;}

}
