CREATE DATABASE upay;
USE upay;

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    accountId VARCHAR(16),
    fname VARCHAR(255),
    lname VARCHAR(255),
    email VARCHAR(255),
    number VARCHAR(11),
    pin INT
);

SELECT * FROM users;

CREATE TABLE user_savings(
	id INT PRIMARY KEY AUTO_INCREMENT,
    accountId VARCHAR(16),
    number VARCHAR(255),
    savings DOUBLE
    );

SELECT * FROM user_savings;

CREATE TABLE viewTransactions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    name VARCHAR(255),
    accountId VARCHAR(16),
    dates DATE,
    transferToId VARCHAR(16),
    transferFromId VARCHAR(16)
);