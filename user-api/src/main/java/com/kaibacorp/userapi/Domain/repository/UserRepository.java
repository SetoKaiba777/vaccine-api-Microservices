package com.kaibacorp.userapi.Domain.repository;

import com.kaibacorp.userapi.Domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByCpf(String cpf);
    public User findByEmail(String email);
}
