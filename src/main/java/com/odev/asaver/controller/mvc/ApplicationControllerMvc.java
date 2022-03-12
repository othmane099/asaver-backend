package com.odev.asaver.controller.mvc;

import com.odev.asaver.controller.mvc.routes.ApplicationRoutes;
import com.odev.asaver.dto.ApplicationDto;
import com.odev.asaver.services.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@Slf4j
public class ApplicationControllerMvc implements ApplicationRoutes {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationControllerMvc(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Override
    public String findAll(Model model) {
        List<ApplicationDto> applicationDtoList = applicationService.findAll();
        model.addAttribute("applications", applicationDtoList);
        return "main";
    }


}
