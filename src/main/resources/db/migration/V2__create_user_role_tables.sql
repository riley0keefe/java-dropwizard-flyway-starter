CREATE TABLE `role` (
	role_id TINYINT NOT NULL,
    name varchar(64) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE `user` (
	username varchar(64) NOT NULL,
    password varchar(64) NOT NULL,
    role_id TINYINT NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);