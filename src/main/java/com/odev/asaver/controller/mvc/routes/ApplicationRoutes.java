package com.odev.asaver.controller.mvc.routes;

import com.odev.asaver.dto.ApplicationDto;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.odev.asaver.utils.Constants.APP_ROOT_MVC;

public interface ApplicationRoutes {

    //    ApplicationDto save(@RequestBody ApplicationDto dto);

//    ApplicationDto findById(@PathVariable("idApplication") Long idApplication);

//    ApplicationDto findByName(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT_MVC + "/applications")
    String findAll(Model model);

//    void delete(@PathVariable("idApplication") Long id);

}
