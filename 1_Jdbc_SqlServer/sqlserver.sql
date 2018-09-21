create database JDBCDemo
go

use JDBCDemo
go

create table users(
id INT PRIMARY KEY Identity(1,1),
username varchar(20),
password varchar(20)
)
go

create table Account(
id INT PRIMARY KEY Identity(1,1),
name varchar(20),
balance int check(balance>=0)
)
go

insert into users values('Kate','123')
insert into users values('Alice','123')
insert into users values('Star','123')
insert into users values('Steve','123')
go

insert into Account values('kate',500)
insert into Account values('Tom',500)
go

CREATE PROCEDURE all_stu
AS
SELECT * FROM Student
go

CREATE PROCEDURE insert_user
@n VARCHAR(20),
@a VARCHAR(20)
AS
INSERT INTO student(NAME,age) VALUES(@n,@a)
go

CREATE PROCEDURE getAgeByName
@n VARCHAR(20),
@ret_age INT output
AS
BEGIN
DECLARE @a INT
SELECT @a=age FROM student WHERE NAME=@n;
SET @ret_age=@a;
END
go

select * from users
select * from Account
select * from student
