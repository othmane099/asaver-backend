package com.odev.asaver.controller;

import com.odev.asaver.controller.api.ApplicationApi;
import com.odev.asaver.dto.ApplicationDto;
import com.odev.asaver.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController implements ApplicationApi {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }


    @Override
    public ApplicationDto save(ApplicationDto dto) {
        return applicationService.save(dto);
    }

    @Override
    public ApplicationDto findById(Long id) {
        return applicationService.findById(id);
    }

    @Override
    public ApplicationDto findByName(String name) {
        return applicationService.findByName(name);
    }

    @Override
    public List<ApplicationDto> findAll() {
        return applicationService.findAll();
    }

    @Override
    public void delete(Long id) {
        applicationService.delete(id);
    }
}
