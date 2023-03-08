package com.example.demo.repository;
import com.example.demo.model.BMI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BMIRepository extends JpaRepository<BMI, Long> {
}
