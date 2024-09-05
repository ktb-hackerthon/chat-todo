package com.demo.chattodo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.chattodo.domain.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
