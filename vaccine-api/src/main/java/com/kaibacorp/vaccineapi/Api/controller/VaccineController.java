package com.kaibacorp.vaccineapi.Api.controller;

import com.kaibacorp.vaccineapi.Domain.model.Vaccine;
import com.kaibacorp.vaccineapi.Domain.service.VaccineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vaccine Endpoint")
@RestController
@RequestMapping("/vaccine-service")
@AllArgsConstructor
public class VaccineController {

    private VaccineService vaccineService;

    @Operation(summary = "List all vaccines")
    @GetMapping
    public List<Vaccine> allVac(){
        return vaccineService.allVac();
    }

    @Operation(summary = "List all Vaccines of user with specific id")
    @GetMapping("/user/{id}")
    public List<Vaccine> userVac(@PathVariable Long id){
        return vaccineService.userVac(id);
    }

    @Operation(summary = "Post new vaccine registry")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine addVac(@RequestBody Vaccine vaccine){
        return vaccineService.addVac(vaccine);
    }

    @Operation(summary = "Delete all vaccine of specific user id")
    @DeleteMapping("/user/{id}")
    public void deleteUserVac(@PathVariable Long id){
        vaccineService.deleteByUser(id);
    }
}
