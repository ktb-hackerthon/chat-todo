package com.demo.chattodo.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.chattodo.domain.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {
	List<Schedule> findAllByMemberId(String memberId);

	Optional<Schedule> findByIdAndMemberId(Long id, String memberId);
}
