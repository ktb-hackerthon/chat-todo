package com.demo.chattodo.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.chattodo.domain.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	// 유저의 일정기간내 모든 일정 가져오기
	@Query("SELECT s FROM Schedule s WHERE s.memberId = :memberId AND s.startDateTime >= :startDate AND s.endDateTime <= :endDate ORDER BY s.startDateTime ASC ")
	List<Schedule> findAllByDateRangeAndMemberId(@Param("startDate") LocalDateTime startDate,
		@Param("endDate") LocalDateTime endDate, @Param("memberId") String memberId);

	Optional<Schedule> findByIdAndMemberId(Long id, String memberId);
}
