package com.settlement.dataharvester.domain.dto.payment;

import com.settlement.dataharvester.domain.entity.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CollectForm {

    private Long productId;

    private long paymentAmount;

    private PaymentStatus paymentMethod;

    private LocalDateTime paymentDatetime;

    private String paymentStatus;

    private UUID sellerId;

    private UUID buyerId;
}
