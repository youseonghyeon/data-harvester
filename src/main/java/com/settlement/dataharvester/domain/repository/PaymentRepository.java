package com.settlement.dataharvester.domain.repository;

import com.settlement.dataharvester.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
