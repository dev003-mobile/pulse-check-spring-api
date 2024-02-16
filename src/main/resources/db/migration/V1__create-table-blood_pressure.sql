CREATE TABLE blood_pressure(
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    unit VARCHAR(50) NOT NULL,
    measurement_value SMALLINT NOT NULL,
    measurement_date DATE NOT NULL,
    measurement_time TIME NOT NULL,
    user_id VARCHAR(255) UNIQUE NOT NULL
);