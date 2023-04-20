package com.settlement.dataharvester.domain.repository;

import com.settlement.dataharvester.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
