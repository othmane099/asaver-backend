package com.odev.asaver.controller.api;

import com.odev.asaver.dto.ApplicationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.odev.asaver.utils.Constants.APP_ROOT;

public interface ApplicationApi {

    @PostMapping(value = APP_ROOT + "/applications/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ApplicationDto save(@RequestBody ApplicationDto dto);

    @GetMapping(value = APP_ROOT + "/applications/{idApplication}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApplicationDto findById(@PathVariable("idApplication") Long idApplication);

    @GetMapping(value = APP_ROOT + "/applications/n/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApplicationDto findByName(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT + "/applications/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ApplicationDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/applications/delete/{idApplication}")
    void delete(@PathVariable("idApplication") Long id);



}
