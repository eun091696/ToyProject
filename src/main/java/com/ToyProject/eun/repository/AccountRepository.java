package com.ToyProject.eun.repository;

import com.ToyProject.eun.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int saveUser(Account account) throws Exception;
}
