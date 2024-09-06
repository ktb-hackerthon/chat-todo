package com.demo.chattodo.domain.controller;

import java.time.LocalDate;
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
import com.demo.chattodo.domain.service.ScheduleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;

	@GetMapping
	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(
		@RequestHeader("member_id") String memberId,
		@RequestParam("start_date") LocalDate startDate,
		@RequestParam(value = "start_time", required = false) LocalTime startTime,
		@RequestParam("end_date") LocalDate endDate,
		@RequestParam(value = "end_time", required = false) LocalTime endTime) {

		if (startTime == null) {
			startTime = LocalTime.MIN;
		}

		if (endTime == null) {
			endTime = LocalTime.MAX;
		}

		return scheduleService.countScheduleOfEachDay(
			memberId,
			startDate.atTime(startTime),
			endDate.atTime(endTime)
		);
	}

	@PostMapping
	public ResponseEntity<?> createSchedule(
		@RequestHeader("member_id") String memberId,
		@RequestBody ScheduleCreateDTO dto) {

		return ResponseEntity.ok().body(scheduleService.saveSchedule(memberId, dto));
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

	@PutMapping("/{scheduleId}")
	public ResponseEntity<?> updateSchedule(
		@RequestHeader("member_id") String memberId,
		@PathVariable Long scheduleId,
		@RequestBody ScheduleUpdateDTO dto) {

		scheduleService.updateSchedule(memberId, scheduleId, dto);
		return ResponseEntity.ok().build();
	}
}
