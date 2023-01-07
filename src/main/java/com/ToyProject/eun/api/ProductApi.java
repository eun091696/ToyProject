package com.ToyProject.eun.api;

import com.ToyProject.eun.dto.CMRespDto;
import com.ToyProject.eun.dto.ProductDto;
import com.ToyProject.eun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @PostMapping("/registration")
    public ResponseEntity<?> productRegister(@RequestBody ProductDto productDto) throws Exception {
        productService.productRegister(productDto);
        return ResponseEntity.ok().body(new CMRespDto<>("success", productDto.getClass()));
    }
}
