package com.ToyProject.eun.api;

import com.ToyProject.eun.dto.CMRespDto;
import com.ToyProject.eun.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping("/names")
    public ResponseEntity<?> category() throws Exception {
        return ResponseEntity.ok().body(new CMRespDto<>("Get CategoryName", categoryService.categoryList()));
    }

    @GetMapping("/menu")
    public ResponseEntity<?> menu() throws Exception {
        return ResponseEntity.ok().body(new CMRespDto<>("Get Menu", null));
    }
}
