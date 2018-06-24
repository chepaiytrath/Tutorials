package com.demo.bs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bs.project.domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}