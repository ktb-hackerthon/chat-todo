package com.demo.chattodo.domain.controller;


import java.time.LocalDate;
import java.util.List;

import com.demo.chattodo.domain.dto.request.ScheduleUpdateDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.demo.chattodo.domain.dto.response.ScheduleCountResponseDTO;
import com.demo.chattodo.domain.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;


	@GetMapping
	public List<ScheduleCountResponseDTO> countScheduleOfEachDay(
			@RequestHeader("member_id")String memberId,
			@RequestParam("start_date") LocalDate startDate,
			@RequestParam("end_date")LocalDate endDate) {

		return scheduleService.countScheduleOfEachDay(memberId, startDate, endDate);
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
