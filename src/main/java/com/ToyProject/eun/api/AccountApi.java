package com.ToyProject.eun.api;

import com.ToyProject.eun.Validation.ValidationSequence;
import com.ToyProject.eun.aop.annotation.LogAspect;
import com.ToyProject.eun.dto.AccountDto;
import com.ToyProject.eun.dto.CMRespDto;
import com.ToyProject.eun.security.PrincipalDetails;
import com.ToyProject.eun.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated({ValidationSequence.class}) @RequestBody AccountDto accountDto, BindingResult bindingResult) throws Exception {

        accountService.duplicateUsername(accountDto);
        accountService.passwordChecking(accountDto);
        accountService.register(accountDto);

        return ResponseEntity.created(URI.create("/login")).body(new CMRespDto<>("Success", accountDto.getUsername()));
    }

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception {
        return ResponseEntity.ok().body(new CMRespDto<>("success", principalDetails == null ? "" : principalDetails));
    }
}
