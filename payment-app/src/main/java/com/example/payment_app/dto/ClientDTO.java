package com.example.payment_app.dto;

import lombok.Data;


import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
@Data
public class ClientDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Pattern(regexp = "^\\+?\\d+$", message = "Phone number is invalid")
    private String phoneNumber;

    @Min(value = 0, message = "Balance cannot be negative")
    private BigDecimal balance;
}