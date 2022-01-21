package com.example.logintest.service;

import com.example.logintest.accounts.AccountRepository;
import com.example.logintest.dto.AccountSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public Long save(AccountSaveRequestDto requestDto) {
        return accountRepository.save(requestDto.toEntity()).getId();
    }
}
