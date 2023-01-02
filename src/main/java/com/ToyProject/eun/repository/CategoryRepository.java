package com.ToyProject.eun.repository;

import com.ToyProject.eun.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    public List<Category> getCategoryNames() throws Exception;
}
