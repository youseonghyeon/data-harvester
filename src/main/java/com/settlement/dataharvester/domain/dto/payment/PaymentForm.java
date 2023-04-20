package com.settlement.dataharvester.domain.dto.payment;

import com.settlement.dataharvester.domain.entity.PaymentMethod;
import com.settlement.dataharvester.domain.entity.PaymentStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentForm {

    @NotEmpty
    private Long productId;

    @NotEmpty
    private long paymentAmount;

    @NotEmpty
    private PaymentMethod paymentMethod;

    @NotEmpty
    private LocalDateTime paymentDatetime;

    @NotEmpty
    private PaymentStatus paymentStatus;

    @NotEmpty
    private Long sellerId;

    @NotEmpty
    private Long buyerId;
}
