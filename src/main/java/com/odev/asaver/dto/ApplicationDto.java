package com.odev.asaver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odev.asaver.models.Application;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApplicationDto {

    private Long id;

    private String name;

    @JsonIgnore
    private List<AccountDto> accounts;

    public static ApplicationDto fromEntity(Application application) {
        if (application == null) return null;
        return ApplicationDto.builder()
                .id(application.getId())
                .name(application.getName())
                .build();

    }

    public static Application toEntity(ApplicationDto dto) {
        if (dto == null) return null;
        Application application = new Application();
        application.setId(dto.getId());
        application.setName(dto.getName());
        return application;
    }
}
