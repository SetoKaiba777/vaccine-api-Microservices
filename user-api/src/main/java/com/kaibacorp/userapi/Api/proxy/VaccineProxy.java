package com.kaibacorp.userapi.Api.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "vaccine-service",url = "localhost:8100")
public interface VaccineProxy {

    @DeleteMapping("vaccine-service/user/{id}")
    public void deleteUserVac(@PathVariable Long id);
}
