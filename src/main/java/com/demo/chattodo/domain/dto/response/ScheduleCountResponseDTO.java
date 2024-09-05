package com.demo.chattodo.domain.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScheduleCountResponseDTO {
    private LocalDate date;
    private Long count;
}