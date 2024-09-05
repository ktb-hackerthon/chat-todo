package com.demo.chattodo.domain.dto.request;

import com.demo.chattodo.domain.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
