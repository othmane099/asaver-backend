package com.odev.asaver.services.impl;

import com.odev.asaver.dto.AccountDto;
import com.odev.asaver.exception.ASaverException;
import com.odev.asaver.repository.AccountRepository;
import com.odev.asaver.services.AccountService;
import com.odev.asaver.validator.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public AccountDto save(AccountDto dto) {
        List<String> errors = AccountValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Account is not valid or null {}", dto);
            throw new ASaverException("Entity Account is invalid or null", errors);
        }

        return AccountDto.fromEntity(
                accountRepository.save(
                        AccountDto.toEntity(dto)));
    }

    @Override
    @Transactional
    public AccountDto findById(Long id) {
        if (id == null){
            log.error("Account ID is null");
            return null;
        }

        return accountRepository.findById(id).map(AccountDto::fromEntity).orElseThrow(() ->
                new ASaverException("Account with ID = "+id+" doesn't exist in DB"));
    }

    @Override
    @Transactional
    public List<AccountDto> findAllByEmail(String email) {
        if (!StringUtils.hasLength(email)){
            log.error("email is null");
            return null;
        }

        return accountRepository.findAllByEmail(email).stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<AccountDto> findAllByPassword(String password) {
        if (!StringUtils.hasLength(password)){
            log.error("password is null");
            return null;
        }
        return accountRepository.findAllByPassword(password).stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAllByApplicationId(Long idApplication) {
        if (idApplication == null){
            log.error("id Application is null");
            return null;
        }
        return accountRepository.findAllByApplicationId(idApplication).stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Account ID is null");
            throw new ASaverException("Your id account is null");
        }

        accountRepository.deleteById(id);
    }
}
