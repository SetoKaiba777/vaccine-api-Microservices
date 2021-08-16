package com.kaibacorp.vaccineapi.Api.controller;

import com.kaibacorp.vaccineapi.Domain.model.Vaccine;
import com.kaibacorp.vaccineapi.Domain.repository.VaccineRepository;
import com.kaibacorp.vaccineapi.Domain.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccine-service")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> allVac(){
        return vaccineService.allVac();
    }

    @GetMapping("/user/{id}")
    public List<Vaccine> userVac(@PathVariable Long id){
        return vaccineService.userVac(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine addVac(@RequestBody Vaccine vaccine){
        return vaccineService.addVac(vaccine);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserVac(@PathVariable Long id){
        vaccineService.deleteByUser(id);
    }
}
