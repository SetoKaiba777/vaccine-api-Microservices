package com.kaibacorp.userapi.Domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @CPF
    @Column(name = "cpf_code",nullable = false)
    private String cpf;

    @Email
    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "born_date",nullable = false)
    private LocalDate bornDate;

}
