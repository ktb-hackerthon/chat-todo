package com.demo.chattodo.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.chattodo.domain.dto.response.ScheduleCountResponseDTO;
import com.demo.chattodo.domain.entity.Schedule;
import com.demo.chattodo.domain.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(String memberId, LocalDate startDate, LocalDate endDate) {
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
}
