package com.odev.asaver.services;

import com.odev.asaver.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto save(AccountDto dto);

    AccountDto findById(Long id);

    List<AccountDto> findAllByEmail(String email);

    List<AccountDto> findAllByPassword(String password);

    List<AccountDto> findAllByApplicationId(Long idApplication);

    List<AccountDto> findAll();

    void delete(Long id);
}
