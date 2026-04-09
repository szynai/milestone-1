DROP DATABASE IF exists hoa_db;
CREATE DATABASE hoa_db;
USE hoa_db;

CREATE TABLE residents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(150),
    contact VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE visitors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    resident_to_visit VARCHAR(100),
    purpose VARCHAR(150),
    date VARCHAR(50),
    time_in VARCHAR(50),
    status VARCHAR(50)
);

CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(50),
    event_name VARCHAR(100),
    event_date VARCHAR(50),
    status VARCHAR(50)
);
