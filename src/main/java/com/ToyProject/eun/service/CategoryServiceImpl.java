package com.ToyProject.eun.service;

import com.ToyProject.eun.dto.CategoryDto;
import com.ToyProject.eun.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> categoryList() throws Exception {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepository.getCategoryNames().forEach(categoryName -> {
            categoryDtoList.add(categoryName.toDto());
        });
        return categoryDtoList;
    }
}
