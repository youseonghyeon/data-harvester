package com.settlement.dataharvester.domain.service;

import com.settlement.dataharvester.domain.dto.payment.PaymentForm;
import com.settlement.dataharvester.domain.entity.Payment;
import com.settlement.dataharvester.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public void createPayment(PaymentForm paymentForm) {
        Payment payment = new Payment(paymentForm.getProductId(),
                paymentForm.getPaymentAmount(),
                paymentForm.getPaymentMethod(),
                paymentForm.getPaymentDatetime(),
                paymentForm.getPaymentStatus(),
                paymentForm.getSellerId(),
                paymentForm.getBuyerId());
        paymentRepository.save(payment);
    }
}
