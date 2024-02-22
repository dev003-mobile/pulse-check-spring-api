CREATE TABLE blood_pressure(
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    unit VARCHAR(50) NOT NULL,
    measurement_value INT NOT NULL,
    measurement_date DATE NOT NULL,
    measurement_description_date VARCHAR(50) NOT NULL,
    measurement_time TIME NOT NULL,
    user_id VARCHAR(255) NOT NULL
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;