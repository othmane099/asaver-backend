package com.odev.asaver.controller.api;


import com.odev.asaver.dto.AccountDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.odev.asaver.utils.Constants.APP_ROOT;

public interface AccountApi {

    @PostMapping(value = APP_ROOT + "/accounts/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AccountDto save(@RequestBody AccountDto dto);

    @GetMapping(value = APP_ROOT + "/accounts/{idAccount}", produces = MediaType.APPLICATION_JSON_VALUE)
    AccountDto findById(@PathVariable("idAccount") Long id);

    @GetMapping(value = APP_ROOT + "/accounts/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AccountDto> findAll();

    @GetMapping(value = APP_ROOT + "/accounts/e/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AccountDto> findAllByEmail(@PathVariable("email") String email);

    @GetMapping(value = APP_ROOT + "/accounts/p/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AccountDto> findAllByPassword(@PathVariable("password") String password);

    @GetMapping(value = APP_ROOT + "/accounts/application/{idApplication}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AccountDto> findAllByApplicationId(@PathVariable("idApplication") Long idApplication);

    @DeleteMapping(value = APP_ROOT + "/accounts/delete/{idAccount}")
    void delete(@PathVariable("idAccount") Long id);

}
