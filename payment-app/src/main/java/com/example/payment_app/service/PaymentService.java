package com.example.payment_app.service;

import com.example.payment_app.dto.TransferDTO;
import com.example.payment_app.exception.ClientNotFoundException;
import com.example.payment_app.model.Client;
import com.example.payment_app.model.Payment;
import com.example.payment_app.repository.ClientRepository;
import com.example.payment_app.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public void transferMoney(TransferDTO transferDTO) {
        Client sender = clientRepository.findById(transferDTO.getSenderId())
                .orElseThrow(() -> new ClientNotFoundException("Sender not found"));

        Client recipient = clientRepository.findById(transferDTO.getRecipientId())
                .orElseThrow(() -> new ClientNotFoundException("Recipient not found"));

        BigDecimal amount = transferDTO.getAmount();

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        sender.setBalance(sender.getBalance().subtract(amount));
        recipient.setBalance(recipient.getBalance().add(amount));

        Payment payment = new Payment();
        payment.setDate(LocalDateTime.now());
        payment.setAmount(amount);
        payment.setRecipient(recipient.getName());
        payment.setMessage(transferDTO.getMessage());
        payment.setClient(sender);

        clientRepository.save(sender);
        clientRepository.save(recipient);
        paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsForClient(Long clientId) {
        return paymentRepository.findByClient_Id(clientId);
    }
}
