USE demo;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    greeting_count int NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;
