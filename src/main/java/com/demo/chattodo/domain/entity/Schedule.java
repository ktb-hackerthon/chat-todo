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

	public Schedule(String memberId, String title, LocalDateTime startDateTime, LocalDateTime endDateTime,
		@Nullable String place) {
		this.memberId = memberId;
		this.title = title;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.place = place;
	}

	public void update(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String place) {
		this.title = title;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.place = place;
	}
}
