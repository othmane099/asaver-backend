package com.odev.asaver.validator;

import com.odev.asaver.dto.ApplicationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ApplicationValidator {

    public static List<String> validate(ApplicationDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getName())) {
            errors.add("Please check your application name's field");
        }
        return errors;
    }
}
