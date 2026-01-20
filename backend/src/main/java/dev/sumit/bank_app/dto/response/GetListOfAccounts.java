package dev.sumit.bank_app.dto.response;

import dev.sumit.bank_app.bankingcore.Transaction;
import dev.sumit.bank_app.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GetListOfAccounts {
    private Long accountId;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private BigDecimal balance;
    private List<Transaction> transactions;
    private List<String> comments;

}
