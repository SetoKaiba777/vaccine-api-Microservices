package com.kaibacorp.vaccineapi.Domain.service;

import com.kaibacorp.vaccineapi.Api.proxy.UserProxy;
import com.kaibacorp.vaccineapi.Domain.exception.DontFoundEntityException;
import com.kaibacorp.vaccineapi.Domain.model.Vaccine;
import com.kaibacorp.vaccineapi.Domain.repository.VaccineRepository;
import com.kaibacorp.vaccineapi.Domain.response.User;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private UserProxy userProxy;

    public List<Vaccine> allVac(){
        return vaccineRepository.findAll();
    }

    public List<Vaccine> userVac(Long id){
        return vaccineRepository.findByUserId(id);
    }

    public void deleteByUser(Long id){
        var userVac = this.userVac(id);
        vaccineRepository.deleteAll(userVac);
    }

    public Vaccine addVac(Vaccine vaccine) {
        var id = vaccine.getUserId();
        try{
        var user = userProxy.findUser(id);}
        catch (FeignException.FeignClientException e){
            throw new DontFoundEntityException("This user don't found in our database");
        }
        vaccine.setVac_date(LocalDate.now());
        return vaccineRepository.save(vaccine);
    }

}
