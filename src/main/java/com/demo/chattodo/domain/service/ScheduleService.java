package com.demo.chattodo.domain.service;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import com.demo.chattodo.domain.entity.Schedule;
import com.demo.chattodo.domain.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import com.demo.chattodo.domain.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	@Transactional
	public Long saveSchedule(String memberId, ScheduleCreateDTO dto) {

		Schedule schedule = new Schedule(
				memberId,
				dto.getTitle(),
				DateTimeUtil.getStartLocalDateTime(dto.getStartDate(), dto.getStartTime()),
				DateTimeUtil.getEndLocalDateTime(dto.getEndDate(), dto.getEndTime()),
				dto.getPlace()
		);

		scheduleRepository.save(schedule);

		return schedule.getId();
	}
}
