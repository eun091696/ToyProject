package com.ToyProject.eun.dto;

import com.ToyProject.eun.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int id;
    private String category_name;
    private String category_url;
}
