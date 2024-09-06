package com.demo.chattodo.domain.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import com.demo.chattodo.domain.dto.request.ScheduleUpdateDTO;
import com.demo.chattodo.domain.dto.response.ScheduleCountResponseDTO;
import com.demo.chattodo.domain.dto.response.ScheduleInfoResponseDTO;
import com.demo.chattodo.domain.service.ReminderService;
import com.demo.chattodo.domain.service.ScheduleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;
	private final ReminderService reminderService;

	@GetMapping("/")
	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(
		@RequestHeader("member_id") String memberId,
		@RequestParam("start_date") LocalDate startDate,
		@RequestParam("end_date") LocalDate endDate) {

		return scheduleService.countScheduleOfEachDay(memberId, startDate, endDate);
	}

	@GetMapping("/search")
	public List<ScheduleInfoResponseDTO> searchAllByConditions(
		@RequestHeader("member_id") String memberId,
		@RequestParam(value = "start_date", required = false) LocalDate startDate,
		@RequestParam(value = "start_time", required = false) LocalTime startTime,
		@RequestParam(value = "end_date", required = false) LocalDate endDate,
		@RequestParam(value = "end_time", required = false) LocalTime endTime,
		@RequestParam(value = "title", required = false) String title,
		@RequestParam(value = "place", required = false) String place) {

		LocalDateTime startDateTime = null;

		if (startDate != null) {
			startDateTime = LocalDateTime.of(startDate, LocalTime.MIN);
			if (startTime != null) {
				startDateTime = LocalDateTime.of(startDate, startTime);
			}
		}

		LocalDateTime endDateTime = null;
		if (endDate != null) {
			endDateTime = LocalDateTime.of(endDate, LocalTime.MAX);
			if (endTime != null) {
				endDateTime = LocalDateTime.of(endDate, endTime);
			}
		}

		return scheduleService.searchAllByConditions(memberId, startDateTime, endDateTime, title, place);
	}

	@PostMapping("/")
	public ResponseEntity<?> createSchedule(
		@RequestHeader("member_id") String memberId,
		@RequestBody ScheduleCreateDTO dto) {

		return ResponseEntity.ok().body(scheduleService.saveSchedule(memberId, dto));
	}

	@PutMapping("/{scheduleId}")
	public ResponseEntity<?> updateSchedule(
		@RequestHeader("member_id") String memberId,
		@PathVariable Long scheduleId,
		@RequestBody ScheduleUpdateDTO dto) {

		scheduleService.updateSchedule(memberId, scheduleId, dto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<?> deleteSchedule(
		@RequestHeader("member_id") String memberId,
		@PathVariable Long scheduleId) {

		if (scheduleService.deleteSchedule(memberId, scheduleId)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/reminder")
	public ResponseEntity<?> getRemainder(
		@RequestHeader("member_id") String memberId,
		@RequestParam(value = "current_date_time") LocalDateTime currentDateTime,
		@RequestParam(value = "time_range") LocalTime timeRange) {

		return ResponseEntity.ok().body(reminderService.getReminderSchedules(memberId, currentDateTime, timeRange));
	}

}
