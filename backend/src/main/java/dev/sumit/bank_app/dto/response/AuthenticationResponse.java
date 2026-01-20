package dev.sumit.bank_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import dev.sumit.bank_app.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String id;
    private String token;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private Role role;
}
