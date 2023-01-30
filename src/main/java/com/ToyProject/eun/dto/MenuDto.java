package com.ToyProject.eun.dto;

import com.ToyProject.eun.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    private int id;
    private String pdtName;
    private int pdtPrice;
    private String pdtImg;


}
