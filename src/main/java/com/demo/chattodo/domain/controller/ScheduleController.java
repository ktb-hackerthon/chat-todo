package com.demo.chattodo.domain.controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.chattodo.domain.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;
}
