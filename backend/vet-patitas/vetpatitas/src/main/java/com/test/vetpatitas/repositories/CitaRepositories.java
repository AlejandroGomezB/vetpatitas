package com.test.vetpatitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.vetpatitas.entity.CitaEntity;

@Repository
public interface CitaRepositories extends JpaRepository<CitaEntity, Long> {

}
