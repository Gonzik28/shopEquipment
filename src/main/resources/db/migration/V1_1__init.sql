CREATE TABLE IF NOT EXISTS equipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serial_number BIGINT,
    producer VARCHAR(255),
    price DECIMAL(10, 2),
    count INT,
    equipment_type VARCHAR(255),
    form_factor VARCHAR(255),
    capacity BIGINT,
    size INT,
    diagonal INT
);