package com.demo.chattodo.domain.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleCreateDTO {

	String title;

	@JsonProperty("start_date")
	LocalDate startDate;

	@JsonProperty("start_time")
	LocalTime startTime;

	@JsonProperty("end_date")
	LocalDate endDate;

	@JsonProperty("end_time")
	LocalTime endTime;

	String place;

}
