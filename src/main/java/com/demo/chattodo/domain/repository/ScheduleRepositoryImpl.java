package com.demo.chattodo.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.chattodo.domain.entity.QSchedule;
import com.demo.chattodo.domain.entity.Schedule;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	// 여러 조건들을 통해 일정 가져오기
	@Override
	public List<Schedule> searchAllByConditions(String memberId, LocalDateTime startDateTime, LocalDateTime endDateTime,
		String title,
		String place) {
		QSchedule schedule = QSchedule.schedule;

		BooleanBuilder builder = new BooleanBuilder();

		// 멤버 ID는 필수 조건
		builder.and(schedule.memberId.eq(memberId));

		// 시작일시 조건
		if (startDateTime != null) {
			builder.and(schedule.startDateTime.goe(startDateTime));
		}

		// 종료일시 조건
		if (endDateTime != null) {
			builder.and(schedule.endDateTime.loe(endDateTime));
		}

		// 제목 조건 (부분 일치)
		if (title != null && !title.isEmpty()) {
			builder.and(schedule.title.containsIgnoreCase(title));
		}

		// 장소 조건 (부분 일치)
		if (place != null && !place.isEmpty()) {
			builder.and(schedule.place.containsIgnoreCase(place));
		}

		return queryFactory
			.selectFrom(schedule)
			.where(builder)
			.orderBy(schedule.startDateTime.asc())
			.fetch();
	}
}
