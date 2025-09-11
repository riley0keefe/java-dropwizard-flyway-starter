CREATE TABLE delivery_employee (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(64) NOT NULL CHECK (first_name <> ""),
    middle_name VARCHAR(64),
    last_name VARCHAR(64) NOT NULL CHECK (last_name <> ""),
    salary DECIMAL(16, 2) NOT NULL CHECK (salary >= 0),
    bank_account_number VARCHAR(32) NOT NULL UNIQUE CHECK (bank_account_number <> ""),
    national_insurance_number VARCHAR(32) NOT NULL UNIQUE
        CHECK (
            CHAR_LENGTH(national_insurance_number) = 9   -- Canada (SIN)
            OR CHAR_LENGTH(national_insurance_number) = 15  -- France (INSEE)
            OR CHAR_LENGTH(national_insurance_number) = 19  -- China (ID)
        )
);