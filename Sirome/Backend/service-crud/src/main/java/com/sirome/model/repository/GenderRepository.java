package com.sirome.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirome.model.entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{

}
