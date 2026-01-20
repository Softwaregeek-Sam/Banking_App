package dev.sumit.bank_app.dto.response;


import dev.sumit.bank_app.bankingcore.Transaction;
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
public class BalanceOperationsResponse {
    private BigDecimal balance;
    private List<Transaction> transactions;
}