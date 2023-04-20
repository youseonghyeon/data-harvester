package com.settlement.dataharvester.domain.controller;

import com.settlement.dataharvester.domain.dto.payment.PaymentForm;
import com.settlement.dataharvester.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides data collection functionality.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentHarvester {

    private final PaymentService paymentService;

    @PostMapping("/settlement/collect")
    public void collectPayments(@Validated @RequestBody PaymentForm paymentForm) {
        paymentService.createPayment(paymentForm);
    }

}


