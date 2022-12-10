package com.ToyProject.eun.service;

import com.ToyProject.eun.dto.AccountDto;
import org.springframework.stereotype.Service;

public interface AccountService {
    public void register(AccountDto accountDto) throws Exception;
}
