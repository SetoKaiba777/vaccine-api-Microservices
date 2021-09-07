package com.kaibacorp.vaccineapi.Api.proxy;

import com.kaibacorp.vaccineapi.Domain.response.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", url = "localhost:8761")
public interface UserProxy {

    @GetMapping("user-service/{id}")
    public User findUser(@PathVariable Long id);
}
