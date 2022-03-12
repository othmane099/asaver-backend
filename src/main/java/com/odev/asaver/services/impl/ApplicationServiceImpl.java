package com.odev.asaver.services.impl;

import com.odev.asaver.dto.ApplicationDto;
import com.odev.asaver.exception.ASaverException;
import com.odev.asaver.models.Account;
import com.odev.asaver.repository.AccountRepository;
import com.odev.asaver.repository.ApplicationRepository;
import com.odev.asaver.services.ApplicationService;
import com.odev.asaver.validator.ApplicationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  AccountRepository accountRepository) {
        this.applicationRepository = applicationRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ApplicationDto save(ApplicationDto dto) {
        List<String> errors = ApplicationValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Application is not valid {}", dto);
            throw new ASaverException("Application is not valid", errors);
        }

        return ApplicationDto.fromEntity(
                applicationRepository.save(ApplicationDto.toEntity(dto))
        );
    }

    @Override
    public ApplicationDto findById(Long id) {

        if (id == null){
            log.error("Application ID is null");
            return null;
        }
        return applicationRepository.findById(id)
                .map(ApplicationDto::fromEntity)
                .orElseThrow(()->new ASaverException("Application with this  ID = "+id+" doesn't found in DB"));
    }

    @Override
    public List<ApplicationDto> findAllByName(String name) {
        if (!StringUtils.hasLength(name)){
            log.error("name is null");
            return null;
        }

        return applicationRepository.findAllByName(name).stream()
                .map(ApplicationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findAll() {
        return applicationRepository.findAll().stream()
                .map(ApplicationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Application ID is null");
            return;
        }
        List<Account> accounts = accountRepository.findAllByApplicationId(id);
        if (!accounts.isEmpty()) {
            throw new ASaverException("Application entity is not empty - has accounts");
        }
        applicationRepository.deleteById(id);
    }
}
