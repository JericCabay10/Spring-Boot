CREATE DATABASE upay;
USE upay;

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    accountID VARCHAR(16),
    fname VARCHAR(255),
    lname VARCHAR(255),
    email VARCHAR(255),
    number VARCHAR(11),
    pin INT
);

SELECT * FROM users