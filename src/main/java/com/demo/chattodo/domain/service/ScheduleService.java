package com.demo.chattodo.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import com.demo.chattodo.domain.dto.request.ScheduleUpdateDTO;
import com.demo.chattodo.domain.dto.response.ScheduleCountResponseDTO;
import com.demo.chattodo.domain.entity.Schedule;
import com.demo.chattodo.domain.repository.ScheduleRepository;
import com.demo.chattodo.domain.utils.DateTimeUtil;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(String memberId, LocalDateTime startDateTime,
		LocalDateTime endDateTime) {
		List<Schedule> schedules = scheduleRepository.findAllByDateRangeAndMemberId(
			startDateTime,
			endDateTime,
			memberId
		);

		Map<LocalDate, Long> countMap = new HashMap<>();
		for (Schedule schedule : schedules) {
			LocalDate startDate = schedule.getStartDateTime().toLocalDate();
			LocalDate endDate = schedule.getEndDateTime().toLocalDate();

			for (LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusDays(1)) {
				countMap.put(date, countMap.getOrDefault(date, 0L) + 1L);
			}
		}

		// countMap의 요소를 key값으로 정렬하여 이를 DTO List로 만들어 return
		List<ScheduleCountResponseDTO> response = new ArrayList<>();

		countMap.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.forEach(entry -> response.add(new ScheduleCountResponseDTO(entry.getKey(), entry.getValue())));

		return response;
	}

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

	@Transactional
	public boolean deleteSchedule(String memberId, Long scheduleId) {
		Optional<Schedule> schedule = scheduleRepository.findByIdAndMemberId(scheduleId, memberId);

		if (schedule.isPresent()) {
			scheduleRepository.delete(schedule.get());
			return true;
		}

		return false;
	}

	@Transactional
	public void updateSchedule(String memberId, Long scheduleId, ScheduleUpdateDTO dto) {
		scheduleRepository.findByIdAndMemberId(scheduleId, memberId)
			.ifPresent(schedule -> schedule.update(dto.getTitle(),
				DateTimeUtil.getStartLocalDateTime(dto.getStartDate(), dto.getStartTime()),
				DateTimeUtil.getEndLocalDateTime(dto.getEndDate(), dto.getEndTime()),
				dto.getPlace()));
	}
}
