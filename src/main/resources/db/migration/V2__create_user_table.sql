CREATE TABLE user (
    user_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(100),
    password varchar(32),
    role_id int,
    FOREIGN KEY(role_id) REFERENCES role(id)
    );