package com.ToyProject.eun.service;

import com.ToyProject.eun.domain.Account;
import com.ToyProject.eun.exception.CustomInternalServerErrorException;
import com.ToyProject.eun.repository.AccountRepository;
import com.ToyProject.eun.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = null;

        try {
            account = accountRepository.findUserByUsername(username);
        }catch (Exception e) {
            throw new CustomInternalServerErrorException("회원 정보 조회 오류");
        }
        if(account == null) {
            throw new UsernameNotFoundException("잘못된 사용자 정보");
        }
        return new PrincipalDetails(account);
    }
}
