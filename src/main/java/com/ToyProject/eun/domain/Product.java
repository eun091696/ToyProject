package com.ToyProject.eun.domain;

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
}
