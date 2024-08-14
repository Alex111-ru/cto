package com.example.payment_app.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TransferDTO {

    @NotNull(message = "Sender ID is required")
    private Long senderId;

    @NotNull(message = "Recipient ID is required")
    private Long recipientId;

    @Min(value = 0, message = "Amount must be greater than zero")
    private BigDecimal amount;

    private String message;
}