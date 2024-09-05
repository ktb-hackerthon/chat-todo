package com.demo.chattodo.domain.controller;

import com.demo.chattodo.domain.dto.request.ScheduleCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.chattodo.domain.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequestMapping("/schedules")
@RestController
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<?> createSchedule(
			@RequestHeader("member_id") String memberId,
			@RequestBody ScheduleCreateDTO dto) {
		return ResponseEntity.ok().body(scheduleService.saveSchedule(memberId, dto));
	}
}
