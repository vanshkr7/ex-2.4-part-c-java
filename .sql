CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE Student (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Department VARCHAR(100),
    Marks DOUBLE
);
