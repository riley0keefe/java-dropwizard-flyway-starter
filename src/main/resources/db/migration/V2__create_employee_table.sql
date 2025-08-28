CREATE TABLE Employee(
	Employee_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	National_id varchar(15) NOT NULL,
    `Name` varchar(30) NOT NULL,
    Salary float NOT NULL,
    Bank_Account_Num varchar(20) NOT NULL,
    Commission_Rate float NOT NULL,
    Team_id int NOT NULL,
    FOREIGN KEY (Team_id) REFERENCES Team(Team_id)
);