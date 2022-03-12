package com.odev.asaver.validator;

import com.odev.asaver.dto.AccountDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator {

    public static List<String> validate(AccountDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Please check your email");
            errors.add("Please check your password");
            errors.add("Please check your Application");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Please check your email fields");
        }
        if (!StringUtils.hasLength(dto.getPassword())) {
            errors.add("Please check your password fields");
        }
        return errors;
    }
}
