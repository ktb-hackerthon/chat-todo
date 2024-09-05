package com.demo.chattodo.domain.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.demo.chattodo.domain.entity.Schedule;

public interface ScheduleRepositoryCustom {
	// 여러 조건들을 통해 일정 가져오기
	List<Schedule> searchAllByConditions(String memberId, LocalDate startDate, LocalDate endDate, String title, String place);
}
