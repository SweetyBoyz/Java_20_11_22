CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;
DROP TABLE IF EXISTS  people;
CREATE TABLE people
(
    id INT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    surname VARCHAR(255),
    address VARCHAR(255),
    birth INT(2),
    salary INT(10),
    famaly VARCHAR(255)
);
INSERT INTO People(firstname,surname,address,birth,salary,famaly)
VALUES
   ('John','Do','Canada',12,1000,'Y'),
   ('Salim','Salem','Morocco',13,1600,'N'),
   ('Yuri','Puturin','Russia',10,1700,'N'),
   ('Juan','De La Cruiz','Mexico',22,1200,'Y');