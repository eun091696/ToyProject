package com.ToyProject.eun.repository;

import com.ToyProject.eun.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
    public int productRegister(Product product) throws Exception;
}
