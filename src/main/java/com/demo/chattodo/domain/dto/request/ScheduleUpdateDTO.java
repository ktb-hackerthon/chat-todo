package com.demo.chattodo.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleUpdateDTO {

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

    @JsonProperty("reminder_time")
    LocalTime reminderTime;
}
