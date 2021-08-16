package com.kaibacorp.vaccineapi.Domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate bornDate;

}
