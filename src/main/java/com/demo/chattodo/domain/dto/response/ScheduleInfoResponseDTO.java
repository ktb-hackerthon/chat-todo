package com.demo.chattodo.domain.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScheduleInfoResponseDTO {
	private Long id;
	private String title;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private String place;
}
