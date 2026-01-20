package dev.sumit.bank_app.user.auth;


import dev.sumit.bank_app.config.TokenBlacklistRepository;
import dev.sumit.bank_app.dto.request.AuthenticationRequest;
import dev.sumit.bank_app.dto.request.RegisterRequest;
import dev.sumit.bank_app.dto.response.AuthenticationResponse;
import dev.sumit.bank_app.dto.response.RegistrationResponse;
import dev.sumit.bank_app.exceptions.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/**", maxAge = 3600)
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {
    private final AuthenticationService service;
    private final TokenBlacklistRepository blacklistRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(
            @Valid @RequestBody  RegisterRequest request
    ) {
        try {
            RegistrationResponse response = service.register(request);
            return ResponseEntity.ok(response);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        blacklistRepo.add(token);
        return ResponseEntity.noContent().build();
    }



}

