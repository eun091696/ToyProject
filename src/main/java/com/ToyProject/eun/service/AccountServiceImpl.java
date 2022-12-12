package com.ToyProject.eun.service;

import com.ToyProject.eun.dto.AccountDto;
import com.ToyProject.eun.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public void register(AccountDto accountDto) throws Exception {
        int result = accountRepository.saveUser(accountDto.toEntity());
        if(result == 0) {
            System.out.println("회원가입 실패");
        }
    }
}
