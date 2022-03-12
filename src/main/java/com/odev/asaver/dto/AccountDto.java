package com.odev.asaver.dto;

import com.odev.asaver.models.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private Long id;

    private String email;

    private String password;

    private ApplicationDto application;

    public static AccountDto fromEntity(Account account){
        if (account == null) return null;
        return AccountDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .password(account.getPassword())
                .application(ApplicationDto.fromEntity(account.getApplication()))
                .build();
    }

    public static Account toEntity(AccountDto dto){
        if(dto == null) return null;
        Account account = new Account();
        account.setId(dto.getId());
        account.setEmail(dto.getEmail());
        account.setPassword(dto.getPassword());
        account.setApplication(ApplicationDto.toEntity(dto.getApplication()));
        return account;
    }
}
