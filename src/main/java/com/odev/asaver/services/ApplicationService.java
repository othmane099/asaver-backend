package com.odev.asaver.services;

import com.odev.asaver.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {

    ApplicationDto save(ApplicationDto dto);

    ApplicationDto findById(Long id);

    ApplicationDto findByName(String name);

    List<ApplicationDto> findAll();

    void delete(Long id);
}
