package com.demo.chattodo.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.chattodo.domain.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {
	// 유저의 일정기간내 모든 일정 가져오기
	@Query("SELECT s FROM Schedule s WHERE s.memberId = :memberId AND s.startDateTime >= :startDate AND s.endDateTime < :endDate")
	List<Schedule> findAllByDateRangeAndMemberId(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("memberId") String memberId);

	Optional<Schedule> findByIdAndMemberId(Long id, String memberId);

	@Query("SELECT s FROM Schedule s WHERE s.memberId = :memberId AND s.reminderDateTime BETWEEN :searchStartDateTime AND :searchEndDateTime")
	List<Schedule> findRemindersWithinTimeRangeByMemberId(
			@Param("memberId") String memberId,
			@Param("searchStartDateTime") LocalDateTime searchStartDateTime,
			@Param("searchEndDateTime") LocalDateTime searchEndDateTime);
}
