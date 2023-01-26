package com.ToyProject.eun.service;


import com.ToyProject.eun.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> categoryList() throws Exception;
}
