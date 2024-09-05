package com.demo.chattodo.domain.service;

import org.springframework.stereotype.Service;

import com.demo.chattodo.domain.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;
}
