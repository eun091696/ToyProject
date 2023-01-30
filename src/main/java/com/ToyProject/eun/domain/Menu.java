package com.ToyProject.eun.domain;

import com.ToyProject.eun.dto.MenuDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private String pdt_name;
    private int pdt_price;
    private String pdt_img;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public MenuDto toDto() {
        return MenuDto.builder()
                .id(id)
                .pdtName(pdt_name)
                .pdtPrice(pdt_price)
                .pdtImg(pdt_img)
                .build();
    }
}
