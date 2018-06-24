package com.demo.bs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bs.project.domain.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

}