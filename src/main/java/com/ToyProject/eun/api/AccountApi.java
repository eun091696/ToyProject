package com.ToyProject.eun.api;

import com.ToyProject.eun.dto.CMRespDto;
import com.ToyProject.eun.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> register() throws Exception {
        return ResponseEntity.created(URI.create("/login")).body(new CMRespDto<>("Success", null));
    }
}