package com.demo.chattodo.domain.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberId;
	private String title;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;

	@Nullable
	private String place;

	@Nullable
	private LocalDateTime reminderDateTime;

	public Schedule(String memberId, String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String place, LocalDateTime reminderDateTime) {
		this.memberId = memberId;
		this.title = title;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.place = place;
		this.reminderDateTime = reminderDateTime;
	}

	public void update(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String place, LocalDateTime remainderDateTime) {
		this.title = title;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.place = place;
		this.reminderDateTime = remainderDateTime;
	}

	public String getReminderMessage() {
		String message = "";

		message += dateTimeToString(startDateTime) + "부터 " + dateTimeToString(endDateTime) + "까지 ";

		if (place != null) {
			message += place + "에서 ";
		}

		message += "\"" + title + "\"";

		return message;
	}

	private String dateTimeToString(LocalDateTime dateTime) {
		if (dateTime.getSecond() == 59) {
			dateTime = dateTime.plusSeconds(1);
		}

		String message = "";

		int hour = dateTime.getHour();
		String period = hour < 12 ? "오전 " : "오후 ";
		hour = (hour % 12 == 0) ? 12 : (hour % 12);

		message += dateTime.getYear() + "년 " + dateTime.getMonthValue() + "월 " + dateTime.getDayOfMonth() + "일 " + period + hour + "시 ";

		if (dateTime.getMinute() != 0) {
			message += dateTime.getMinute() + "분 ";
		}

		if (dateTime.getSecond() != 0) {
			message += dateTime.getSecond() + "초 ";
		}

		return message;
	}

}
