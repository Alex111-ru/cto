package com.example.payment_app.repository;

import com.example.payment_app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByClient_Id(Long clientId);//не надо мешать case в названии, в методах camelCase
}
