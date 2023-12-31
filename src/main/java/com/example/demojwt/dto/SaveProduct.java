package com.example.demojwt.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class SaveProduct implements Serializable {
    @NotBlank
    private String name;
    @DecimalMin(value = "0.01", message = "el precio debe ser mayor que cero")
    private BigDecimal price;
    @Min(value = 1)
    private Long categoryId;
}
