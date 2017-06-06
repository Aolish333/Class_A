# Class_A
Javaweb课设
# 数据库

CREATE DATABASE class_a;

CREATE TABLE X_Student (
  X_Student_Name VARCHAR(25) ,
  X_Student_User VARCHAR(25)  NULL,
  X_Student_Pwd  VARCHAR(25)  NULL,
  X_Student_No   INT(10) NOT NULL auto_increment,
  PRIMARY KEY (X_Student_No)
)CHARSET = utf8;

CREATE TABLE X_Teacher(
  X_Teacher_Name VARCHAR(25) ,
  X_Teacher_Pwd VARCHAR(25) NOT NULL,
  X_Teacher_User  VARCHAR(25) NOT NULL,
  X_Teacher_No   INT(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (X_Teacher_No)
)CHARSET = utf8;

CREATE TABLE X_Manager (
  X_Manager_User VARCHAR(25) NOT NULL,
  X_Manager_Pwd  VARCHAR(25) NOT NULL,
  X_Manager_ID   INT(10)  NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (X_Manager_ID)
)CHARSET = utf8;

CREATE TABLE X_Course (
  X_Course_Content VARCHAR(25) NOT NULL,
  X_Course_Intro  VARCHAR(25) NOT NULL,
  X_Course_Credit VARCHAR(25) NOT NULL,
  X_Course_Hours VARCHAR(25) NOT NULL,
  X_Course_No INT(10) NOT NULL AUTO_INCREMENT,
  X_Course_Name VARCHAR(25) NOT NULL,
  PRIMARY KEY (X_Course_No)
)CHARSET = utf8;

CREATE TABLE X_Electives(
  X_Electives_OnDuty varchar(25),
  X_Electives_TakeTask Text(65535),
  X_Electives_TR MEDIUMTEXT,
  X_Course_No INT(10),
  X_Student_No INT(10),
  PRIMARY KEY (X_Course_No,X_Student_No),
  FOREIGN KEY(X_Course_No) REFERENCES class_a.x_course(X_Course_No),
  FOREIGN KEY (X_Student_No) REFERENCES class_a.x_student(X_Student_No)
)CHARSET = utf8;


INSERT INTO x_student (X_Student_Name, X_Student_User, X_Student_Pwd) VALUES ("李。。",123,123);

INSERT INTO X_Teacher (X_Teacher_Name, X_Teacher_Pwd, X_Teacher_User) VALUES ("李老师",456,456);

INSERT INTO X_Manager (X_Manager_User, X_Manager_Pwd) VALUES (666666,666666);

INSERT INTO X_Course (X_Course_Content, X_Course_Intro, X_Course_Credit, X_Course_Hours, X_Course_Name) VALUES ("ssddsa","sadjfgkskdafj","2","10学时","数据结构");
