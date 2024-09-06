package com.demo.chattodo.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import com.demo.chattodo.domain.dto.request.ScheduleUpdateDTO;
import com.demo.chattodo.domain.dto.response.ScheduleCountResponseDTO;
import com.demo.chattodo.domain.dto.response.ScheduleInfoResponseDTO;
import com.demo.chattodo.domain.entity.Schedule;
import com.demo.chattodo.domain.repository.ScheduleRepository;
import com.demo.chattodo.domain.utils.DateTimeUtil;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(String memberId, LocalDate startDate,
		LocalDate endDate) {
		List<Schedule> schedules = scheduleRepository.findAllByDateRangeAndMemberId(
			LocalDateTime.of(startDate, LocalTime.MIN),
			LocalDateTime.of(endDate, LocalTime.MIN).plusDays(1),
			memberId
		);

		List<ScheduleCountResponseDTO> response = new ArrayList<>();
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
			LocalDate finalDate = date;
			long count = schedules.stream()
				.filter(schedule -> schedule.getStartDateTime().toLocalDate().equals(finalDate))
				.count();

			if (count == 0) {
				continue;
			}

			response.add(ScheduleCountResponseDTO.builder()
				.date(date)
				.count(count)
				.build());
		}

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

	public List<ScheduleInfoResponseDTO> searchAllByConditions(String memberId, LocalDateTime startDateTime,
		LocalDateTime endDateTime, String title, String place) {
		List<Schedule> schedules = scheduleRepository.searchAllByConditions(
			memberId,
			startDateTime,
			endDateTime,
			title,
			place
		);

		List<ScheduleInfoResponseDTO> response = new ArrayList<>();
		for (Schedule schedule : schedules) {
			response.add(ScheduleInfoResponseDTO.builder()
				.id(schedule.getId())
				.title(schedule.getTitle())
				.startDateTime(schedule.getStartDateTime())
				.endDateTime(schedule.getEndDateTime())
				.place(schedule.getPlace())
				.build());
		}

		return response;
	}

}
