package com.ToyProject.eun.dto;

import com.ToyProject.eun.domain.Account;
import lombok.Data;

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
