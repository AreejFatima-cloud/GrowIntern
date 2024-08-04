create database  BankManagementSystem;
show databases;
use BankManagementSystem;
CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE,
    cnic VARCHAR(15),
    religion VARCHAR(50),
    nationality VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100),
    father_name VARCHAR(50),
    gender VARCHAR(10),
    address TEXT,
    city VARCHAR(50),
    province VARCHAR(50),
    application_no VARCHAR(20)
);
SELECT * FROM customers;

ALTER TABLE customers
ADD COLUMN category VARCHAR(255),
ADD COLUMN income VARCHAR(255),
ADD COLUMN occupation VARCHAR(255),
ADD COLUMN senior_citizen BOOLEAN,
ADD COLUMN pan_number VARCHAR(255);

ALTER TABLE customers
ADD COLUMN qualification VARCHAR(255),
ADD COLUMN existing_account BOOLEAN;

ALTER TABLE customers
ADD COLUMN account_type VARCHAR(50),
ADD COLUMN card_no VARCHAR(19), 
ADD COLUMN pin VARCHAR(4),       
ADD COLUMN services TEXT;        

ALTER TABLE customers
ADD COLUMN Balance double;

SELECT * FROM customers;

