CREATE TABLE `role` (
	role_id TINYINT NOT NULL,
    name varchar(64) NOT NULL,
    PRIMARY KEY (role_id)
);

INSERT INTO role(role_id, name) VALUES(1, 'admin');
INSERT INTO role(role_id, name) VALUES(2, 'hr');
INSERT INTO role(role_id, name) VALUES(3, 'user');

CREATE TABLE `user` (
	username varchar(64) NOT NULL,
    password varchar(64) NOT NULL,
    role_id TINYINT NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

INSERT INTO user(username, password, role_id) VALUES ('admin', 'admin', 1);
INSERT INTO user(username, password, role_id) VALUES ('hr', 'hr', 2);
INSERT INTO user(username, password, role_id) VALUES ('user', 'user', 3