package com.ToyProject.eun.domain;

import com.ToyProject.eun.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String pdt_name;
    private int pdt_price;
    private String pdt_img;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public ProductDto toDto() {
        return ProductDto.builder()
                .pdtImg(pdt_img)
                .pdtName(pdt_name)
                .pdtImg(pdt_img)
                .build();
    }
}
