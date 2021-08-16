package com.kaibacorp.vaccineapi.Domain.repository;

import com.kaibacorp.vaccineapi.Domain.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
    public List<Vaccine> findByUserId(Long id);
}
