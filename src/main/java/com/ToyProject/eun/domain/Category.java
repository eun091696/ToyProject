package com.ToyProject.eun.domain;

import com.ToyProject.eun.dto.CategoryDto;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Category {
    private int id;
    private String category_name;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public CategoryDto toDto() {
        return CategoryDto.builder()
                .id(id)
                .category_name(category_name)
                .build();
    }
}
