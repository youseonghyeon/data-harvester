package com.settlement.dataharvester.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private long paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentMethod;

    private LocalDateTime paymentDatetime;

    private String paymentStatus;

    private UUID sellerId;
    private UUID buyerId;

    public Payment(Long productId, long paymentAmount, PaymentStatus paymentMethod, LocalDateTime paymentDatetime, String paymentStatus, UUID sellerId, UUID buyerId) {
        this.productId = productId;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentDatetime = paymentDatetime;
        this.paymentStatus = paymentStatus;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
    }
}
