package com.kaibacorp.vaccineapi.Domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Vaccine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vaccine", nullable = false)
    private String vaccine;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name="vac_date")
    private LocalDate vac_date;

}
