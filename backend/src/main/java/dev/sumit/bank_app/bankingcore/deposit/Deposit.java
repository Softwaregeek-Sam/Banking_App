package dev.sumit.bank_app.bankingcore.deposit;

import dev.sumit.bank_app.bankingcore.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@ManyToOne
    private Account account;

    private BigDecimal amount;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private DepositStatus status=DepositStatus.PENDING; // Can be PENDING, APPROVED, or REJECTED

}

