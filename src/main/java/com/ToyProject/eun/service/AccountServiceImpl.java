package com.ToyProject.eun.service;

import com.ToyProject.eun.domain.Account;
import com.ToyProject.eun.dto.AccountDto;
import com.ToyProject.eun.exception.CustomValidationException;
import com.ToyProject.eun.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;



    @Override
    public void duplicateUsername(AccountDto accountDto) throws Exception {
        Account account = accountRepository.findUserByUsername(accountDto.getUsername());
        System.out.println(account);
        if(account != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("username", "이미 사용중인 아이디 입니다.");
            throw new CustomValidationException("Duplicate username", errorMap);
        }
    }

    @Override
    public void passwordChecking(AccountDto accountDto) throws Exception {
        if(!accountDto.getPassword().equals(accountDto.getPasswordChk())) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("passwordChk", "password가 일치하지 않습니다.");
            throw new CustomValidationException("Duplicate username", errorMap);
        }
    }

    @Override
    public void register(AccountDto accountDto) throws Exception {
        int result = accountRepository.saveUser(accountDto.toEntity());
        if(result == 0) {
            System.out.println("회원가입 실패");
        }
    }
}
