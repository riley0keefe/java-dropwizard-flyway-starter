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

DELIMITER //

CREATE PROCEDURE Add_employee (

    IN p_National_ID VARCHAR(16),

    IN p_Name VARCHAR(128),

    IN p_Salary DECIMAL(10, 2),

    IN p_Bank_Account_Num VARCHAR(64),

    IN p_Commission_Rate DECIMAL(5, 2),

    IN p_Team_ID INT

)

BEGIN

    INSERT INTO Employee (

        National_ID,

        `Name`,

        Salary,

        Bank_Account_Num,

        Commission_Rate,

        Team_ID

    )

    VALUES (

        p_National_ID,

        p_Name,

        p_Salary,

        p_Bank_Account_Num,

        COALESCE(p_Commission_Rate, 0.00),

        p_Team_ID

    );

END;

//

DELIMITER ;

 GRANT INSERT ON Flyway_Prod_Kainoos_EvanL.Employee TO 'JohnD'@'%';

 GRANT EXECUTE ON PROCEDURE Flyway_Prod_Kainoos_EvanL.Add_employee TO 'JohnD'@'%';