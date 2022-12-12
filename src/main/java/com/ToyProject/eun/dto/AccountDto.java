package com.ToyProject.eun.dto;

import com.ToyProject.eun.domain.Account;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class AccountDto {
    private String username;
    private String password;
    private String passwordChk;


    public Account toEntity() {
        return Account.builder()
                .username(username)
                .password(password)
                .build();
    }

}
