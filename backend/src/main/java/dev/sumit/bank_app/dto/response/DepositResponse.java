package dev.sumit.bank_app.dto.response;

import dev.sumit.bank_app.bankingcore.deposit.DepositStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepositResponse {
    private Long depositId;
private Long accountId;
    private BigDecimal amount;
    @Builder.Default
    private DepositStatus status=DepositStatus.PENDING; // Can be PENDING, APPROVED, or REJECTED

}
