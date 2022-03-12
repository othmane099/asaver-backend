package com.odev.asaver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Account extends BaseEntity{

    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idApplication")
    private Application application;
}
