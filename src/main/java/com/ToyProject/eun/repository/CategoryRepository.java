package com.ToyProject.eun.repository;

import com.ToyProject.eun.domain.Category;
import com.ToyProject.eun.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    public List<Category> getCategoryNames() throws Exception;
    public List<Menu> getMenuList() throws Exception;
}
