DROP TABLE IF EXISTS schedule;

-- Create table if not exists
CREATE TABLE IF NOT EXISTS schedule
(
    id              INT PRIMARY KEY,
    member_id       VARCHAR(255),
    title           VARCHAR(255),
    start_date_time TIMESTAMP,
    end_date_time   TIMESTAMP,
    place           VARCHAR(255)
);

-- Insert data
INSERT INTO schedule (id, member_id, title, start_date_time, end_date_time, place)
VALUES (1, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Team Meeting', '2024-09-10 10:13:47', '2024-09-10 11:22:14',
        'Conference Room 1'),
       (2, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Project Kickoff', '2024-09-07 13:27:32', '2024-09-07 14:35:59',
        'Conference Room 2'),
       (3, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Client Presentation', '2024-09-09 09:49:16', '2024-09-09 11:05:37',
        'Main Office'),
       (4, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Design Review', '2024-09-06 14:08:11', '2024-09-06 15:40:18',
        'Design Lab'),
       (5, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Sprint Planning', '2024-09-08 09:14:23', '2024-09-08 10:53:12',
        'Meeting Room 3'),
       (6, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Code Review', '2024-09-10 11:42:55', '2024-09-10 12:33:18',
        'Meeting Room 1'),
       (7, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Team Building', '2024-09-12 15:03:20', '2024-09-12 17:12:45',
        'Outdoor Garden'),
       (8, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Product Demo', '2024-09-06 13:37:51', '2024-09-06 14:48:30',
        'Main Hall'),
       (9, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Sales Review', '2024-09-12 16:43:09', '2024-09-12 17:28:22',
        'Conference Room 2'),
       (10, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Strategy Session', '2024-09-11 09:23:44', '2024-09-11 10:11:13',
        'Executive Room'),
       (11, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Marketing Discussion', '2024-09-10 15:36:05',
        '2024-09-10 16:47:33', 'Conference Room 3'),
       (12, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Finance Review', '2024-09-06 14:19:14', '2024-09-06 15:52:51',
        'Main Office'),
       (13, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'HR Policy Update', '2024-09-07 09:07:39', '2024-09-07 10:29:04',
        'HR Office'),
       (14, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'IT Infrastructure Meeting', '2024-09-08 11:43:27',
        '2024-09-08 12:27:58', 'IT Room'),
       (15, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Legal Compliance', '2024-09-09 10:50:31', '2024-09-09 11:39:42',
        'Legal Department'),
       (16, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Board Meeting', '2024-09-11 14:16:19', '2024-09-11 15:42:01',
        'Board Room'),
       (17, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Budget Planning', '2024-09-07 09:14:55', '2024-09-07 10:24:03',
        'Finance Office'),
       (18, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Audit Discussion', '2024-09-12 10:21:18', '2024-09-12 11:43:50',
        'Audit Room'),
       (19, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Research Meeting', '2024-09-08 14:44:31', '2024-09-08 15:33:18',
        'Research Lab'),
       (20, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Performance Review', '2024-09-10 15:17:39', '2024-09-10 16:27:45',
        'HR Office'),
       (21, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Training Session', '2024-09-11 10:04:12', '2024-09-11 12:16:44',
        'Training Room'),
       (22, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Press Conference', '2024-09-08 09:38:50', '2024-09-08 10:51:12',
        'Media Room'),
       (23, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Annual General Meeting', '2024-09-09 13:08:05',
        '2024-09-09 14:55:48', 'Main Hall'),
       (24, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Investor Meeting', '2024-09-07 09:31:18', '2024-09-07 10:43:59',
        'Investor Relations Room'),
       (25, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'CEO Briefing', '2024-09-06 09:08:27', '2024-09-06 10:16:50',
        'Executive Room'),
       (26, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Company Anniversary', '2024-09-11 11:35:48', '2024-09-11 12:45:59',
        'Main Hall'),
       (27, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Vendor Meeting', '2024-09-12 14:28:34', '2024-09-12 15:32:01',
        'Vendor Room'),
       (28, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Product Launch', '2024-09-10 09:17:55', '2024-09-10 10:29:18',
        'Main Hall'),
       (29, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Team Outing', '2024-09-06 15:43:27', '2024-09-06 17:12:58',
        'Outdoor Garden'),
       (30, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Training Workshop', '2024-09-08 10:50:31', '2024-09-08 12:39:42',
        'Training Room');

-- 기간이 7일 이상인 Schedule 데이터 5개 추가
INSERT INTO schedule (id, member_id, title, start_date_time, end_date_time, place)
VALUES (42, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Annual Company Retreat', '2024-10-01 09:00:00',
        '2024-10-10 17:00:00', 'Mountain Resort'),
       (43, 'b2c3d4e5-f6g7-8901-h2i3-j4k5l6m7n8o9', 'International Conference', '2024-11-15 08:00:00',
        '2024-11-25 18:00:00', 'Convention Center'),
       (44, 'c3d4e5f6-g7h8-9012-i3j4-k5l6m7n8o9p0', 'Product Launch Campaign', '2024-12-01 00:00:00',
        '2024-12-15 23:59:59', 'Multiple Locations'),
       (45, 'd4e5f6g7-h8i9-0123-j4k5-l6m7n8o9p0q1', 'Year-End Financial Review', '2024-12-20 09:00:00',
        '2024-12-31 17:00:00', 'Corporate Headquarters'),
       (46, 'e5f6g7h8-i9j0-1234-k5l6-m7n8o9p0q1r2', 'New Year Strategic Planning', '2025-01-02 08:00:00',
        '2025-01-15 18:00:00', 'Executive Retreat Center');
VALUES
    (1, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Team Meeting', '2024-09-10 10:13:47', '2024-09-10 11:22:14', 'Conference Room 1'),
    (2, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Project Kickoff', '2024-09-07 13:27:32', '2024-09-07 14:35:59', 'Conference Room 2'),
    (3, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Client Presentation', '2024-09-09 09:49:16', '2024-09-09 11:05:37', 'Main Office'),
    (4, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Design Review', '2024-09-06 14:08:11', '2024-09-06 15:40:18', 'Design Lab'),
    (5, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Sprint Planning', '2024-09-08 09:14:23', '2024-09-08 10:53:12', 'Meeting Room 3'),
    (6, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Code Review', '2024-09-10 11:42:55', '2024-09-10 12:33:18', 'Meeting Room 1'),
    (7, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Team Building', '2024-09-12 15:03:20', '2024-09-12 17:12:45', 'Outdoor Garden'),
    (8, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Product Demo', '2024-09-06 13:37:51', '2024-09-06 14:48:30', 'Main Hall'),
    (9, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Sales Review', '2024-09-12 16:43:09', '2024-09-12 17:28:22', 'Conference Room 2'),
    (10, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Strategy Session', '2024-09-11 09:23:44', '2024-09-11 10:11:13', 'Executive Room'),
    (11, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Marketing Discussion', '2024-09-10 15:36:05', '2024-09-10 16:47:33', 'Conference Room 3'),
    (12, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Finance Review', '2024-09-06 14:19:14', '2024-09-06 15:52:51', 'Main Office'),
    (13, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'HR Policy Update', '2024-09-07 09:07:39', '2024-09-07 10:29:04', 'HR Office'),
    (14, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'IT Infrastructure Meeting', '2024-09-08 11:43:27', '2024-09-08 12:27:58', 'IT Room'),
    (15, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Legal Compliance', '2024-09-09 10:50:31', '2024-09-09 11:39:42', 'Legal Department'),
    (16, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Board Meeting', '2024-09-11 14:16:19', '2024-09-11 15:42:01', 'Board Room'),
    (17, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Budget Planning', '2024-09-07 09:14:55', '2024-09-07 10:24:03', 'Finance Office'),
    (18, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Audit Discussion', '2024-09-12 10:21:18', '2024-09-12 11:43:50', 'Audit Room'),
    (19, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Research Meeting', '2024-09-08 14:44:31', '2024-09-08 15:33:18', 'Research Lab'),
    (20, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Performance Review', '2024-09-10 15:17:39', '2024-09-10 16:27:45', 'HR Office'),
    (21, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Training Session', '2024-09-11 10:04:12', '2024-09-11 12:16:44', 'Training Room'),
    (22, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Press Conference', '2024-09-08 09:38:50', '2024-09-08 10:51:12', 'Media Room'),
    (23, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Annual General Meeting', '2024-09-09 13:08:05', '2024-09-09 14:55:48', 'Main Hall'),
    (24, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Investor Meeting', '2024-09-07 09:31:18', '2024-09-07 10:43:59', 'Investor Relations Room'),
    (25, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'CEO Briefing', '2024-09-06 09:08:27', '2024-09-06 10:16:50', 'Executive Room'),
    (26, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Company Anniversary', '2024-09-11 11:35:48', '2024-09-11 12:45:59', 'Main Hall'),
    (27, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Vendor Meeting', '2024-09-12 14:28:34', '2024-09-12 15:32:01', 'Vendor Room'),
    (28, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Product Launch', '2024-09-10 09:17:55', '2024-09-10 10:29:18', 'Main Hall'),
    (29, 'b1c2d3e4-f5g6-7890-h1i2-j3k4l5m6n7o8', 'Team Outing', '2024-09-06 15:43:27', '2024-09-06 17:12:58', 'Outdoor Garden'),
    (30, 'c1d2e3f4-g5h6-7890-i1j2-k3l4m5n6o7p8', 'Training Workshop', '2024-09-08 10:50:31', '2024-09-08 12:39:42', 'Training Room');

-- 시작 시간이 00:00:00인 경우 (3개)
INSERT INTO schedule (id, member_id, title, start_date_time, end_date_time, place)
VALUES
    (31, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Early Morning Meeting', '2024-09-15 00:00:00', '2024-09-15 10:30:00', 'Conference Room A'),
    (32, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Day-long Workshop', '2024-09-20 00:00:00', '2024-09-20 18:00:00', 'Training Center'),
    (33, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Overnight Project Kickoff', '2024-09-25 00:00:00', '2024-09-26 08:00:00', 'Main Office');

-- 종료 시간이 23:59:59인 경우 (3개)
INSERT INTO schedule (id, member_id, title, start_date_time, end_date_time, place)
VALUES
    (34, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Late Night Coding Session', '2024-09-18 20:00:00', '2024-09-18 23:59:59', 'Development Lab'),
    (35, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'End-of-Month Review', '2024-09-30 14:00:00', '2024-09-30 23:59:59', 'Board Room'),
    (36, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'International Conference Call', '2024-09-22 22:00:00', '2024-09-22 23:59:59', 'Virtual Meeting Room');

-- 9월 1일부터 30일 중 랜덤으로 5개의 일정 추가
INSERT INTO schedule (id, member_id, title, start_date_time, end_date_time, place)
VALUES
    (37, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Quarterly Planning', '2024-09-03 09:30:00', '2024-09-03 12:30:00', 'Strategy Room'),
    (38, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Client Lunch Meeting', '2024-09-17 12:00:00', '2024-09-17 14:00:00', 'Fancy Restaurant'),
    (39, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Team Building Exercise', '2024-09-24 14:00:00', '2024-09-24 17:00:00', 'City Park'),
    (40, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Product Development Review', '2024-09-11 10:00:00', '2024-09-11 11:30:00', 'Innovation Lab'),
    (41, 'a1b2c3d4-e5f6-7890-g1h2-i3j4k5l6m7n8', 'Annual Performance Evaluation', '2024-09-29 13:00:00', '2024-09-29 16:00:00', 'HR Office');