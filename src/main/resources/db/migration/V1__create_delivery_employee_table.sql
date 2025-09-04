CREATE TABLE DeliveryEmployees (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(64) NOT NULL,
   salary DECIMAL(11, 2) NOT NULL,
   bank_number VARCHAR(8) UNIQUE NOT NULL,
   national_insurance_number VARCHAR(8) UNIQUE NOT NULL
);
