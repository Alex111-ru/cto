package com.example.payment_app.controller;

import com.example.payment_app.dto.TransferDTO;
import com.example.payment_app.model.Payment;
import com.example.payment_app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/transfer")
    public ResponseEntity<Void> transferMoney(@Valid @RequestBody TransferDTO transferDTO) {
        paymentService.transferMoney(transferDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Payment>> getPaymentsForClient(@PathVariable Long clientId) {
        return new ResponseEntity<>(paymentService.getPaymentsForClient(clientId), HttpStatus.OK);
    }
}
