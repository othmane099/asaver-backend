package com.odev.asaver.controller;

import com.odev.asaver.controller.api.AccountApi;
import com.odev.asaver.dto.AccountDto;
import com.odev.asaver.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountApi {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public List<AccountDto> findAllByEmail(String email) {
        return accountService.findAllByEmail(email);
    }

    @Override
    public List<AccountDto> findAllByPassword(String password) {
        return accountService.findAllByPassword(password);
    }

    @Override
    public List<AccountDto> findAllByApplicationId(Long idApplication) {
        return accountService.findAllByApplicationId(idApplication);
    }

    @Override
    public AccountDto save(AccountDto dto) {
        return accountService.save(dto);
    }

    @Override
    public AccountDto findById(Long id) {
        return accountService.findById(id);
    }

    @Override
    public List<AccountDto> findAll() {
        return accountService.findAll();
    }

    @Override
    public void delete(Long id) {
        accountService.delete(id);
    }
}
