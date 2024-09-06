package com.demo.chattodo.domain.service;

import com.demo.chattodo.domain.entity.Schedule;
import com.demo.chattodo.domain.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReminderService {
    private final ScheduleRepository scheduleRepository;

    public String getReminderSchedules(String memberId, LocalDateTime currentDateTime, LocalTime timeRange) {

        LocalDateTime searchEndDateTime = currentDateTime
                .plusHours(timeRange.getHour())
                .plusMinutes(timeRange.getMinute())
                .plusSeconds(timeRange.getSecond());

        List<Schedule> schedules = scheduleRepository.findRemindersWithinTimeRangeByMemberId(memberId, currentDateTime, searchEndDateTime);

        if (schedules.isEmpty()) {
            return null;
        }

        return mergeReminderMessage(schedules);
    }

    private String mergeReminderMessage(List<Schedule> schedules) {
        String message = "리마인더 알림이 도착했습니다!\n";

        for (Schedule schedule : schedules) {
            message += "\n" + schedule.getReminderMessage();
        }

        message += "\n\n총 " + schedules.size() + "개의 일정이 있습니다!";
        return message;
    }
    
    
}
