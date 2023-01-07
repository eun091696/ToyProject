package com.ToyProject.eun.dto;

import com.ToyProject.eun.domain.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private String pdtName;
    private int pdtPrice;
    private String pdtImg;

    public Product toEntity() {
        return Product.builder()
                .pdt_name(pdtName)
                .pdt_price(pdtPrice)
                .pdt_img(pdtImg)
                .build();
    }
}
