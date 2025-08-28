CREATE TABLE Employee(
	Employee_ID SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
	National_ID varchar(16) NOT NULL,
    `Name` varchar(128) NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL,
    Bank_Account_Num varchar(64) NOT NULL,
    Commission_Rate DECIMAL(5, 2) DEFAULT 0.00,
    Team_ID int,
    FOREIGN KEY (Team_ID) REFERENCES Team(Team_ID)
);

INSERT INTO Employee (National_ID, `Name`, Salary, Bank_Account_Num, 
	Commission_Rate, Team_ID)
SELECT '123256289', 'Ryan Murphy', 120000.36, '123abc45', 100, 3 -- Replace with employee info here
WHERE EXISTS (
    SELECT * 
	FROM Employee
	WHERE Team_ID = 1 AND Employee_ID = 3 -- Enter Employee_ID here
);