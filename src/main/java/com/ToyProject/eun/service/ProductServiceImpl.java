package com.ToyProject.eun.service;

import com.ToyProject.eun.dto.ProductDto;
import com.ToyProject.eun.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void productRegister(ProductDto productDto) throws Exception {
        int result = productRepository.productRegister(productDto.toEntity());
        if(result == 0) {
            System.out.println("회원가입 실패");
        }
    }
}
