DROP DATABASE IF EXISTS KNK2;
CREATE DATABASE KNK2;
USE KNK2;

CREATE TABLE Subjects
(
    subjectID VARCHAR(255),
    subjectName VARCHAR(255),
    PRIMARY KEY(subjectID)
);

CREATE TABLE City
(
    cityID VARCHAR(255),
    cityName VARCHAR(255),
    state VARCHAR(255),
    postalCode INTEGER,
    PRIMARY KEY(cityID)
);

insert into city values('1', 'Prishtine', 'Kosove', '10000');


CREATE TABLE Address
(
    addressID VARCHAR(255),
    cityID VARCHAR(255),
    street VARCHAR(255),
    PRIMARY KEY (addressID),
    FOREIGN KEY (cityID) REFERENCES City(cityID) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Address values('1', '1', 'Skenderbeu');

CREATE TABLE ClassRoom
(
    classRoomNumber VARCHAR(255),
    PRIMARY KEY(classRoomNumber)
);


CREATE TABLE Student
(
    studentID VARCHAR(255) not null,
    studentName VARCHAR(255) not null,
    studentSurname VARCHAR(255) not null,
    gender CHAR(1) not null,
    phoneNumber VARCHAR(255) not null,
    email VARCHAR(255) not null unique,
    password VARCHAR(255) not null,
    classRoomNumber VARCHAR(255) not null,
    addressID VARCHAR(255) not null,
    birthDate varchar(255) not null,
    age INTEGER not null,
    PRIMARY KEY(studentID),
    FOREIGN KEY(classRoomNumber) REFERENCES classRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Grades
(
    periodID VARCHAR(255),
    studentID VARCHAR(255),
    subjectID VARCHAR(255),
    projects REAL,
    finalTest REAL,
    finalPeriodMark REAL,
    finalGrade REAL,
    PRIMARY KEY(periodID, studentID, subjectID),
    FOREIGN KEY(studentID) references Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Teacher
(
    teacherID VARCHAR(255),
    teacherName VARCHAR (20) NOT NULL,
    teacherSurname VARCHAR(20) NOT NULL,
    phoneNumber INTEGER,
    email VARCHAR(40) unique not null,
    password VARCHAR(255),
    addressID VARCHAR(255),
    subjectID VARCHAR(50),
    PRIMARY KEY(teacherID),
    FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Administrator
(
    administratorID VARCHAR(20),
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(administratorID));

INSERT INTO Administrator VALUES
    ('1','admin3','admin3','admin');

INSERT INTO Subjects VALUES
                         ('1000', 'Matematika 3K'),
                         ('1001', 'Sinjale dhe Sisteme'),
                         ('1002', 'Elektronika'),
                         ('1003', 'Programimi i orientuar ne objekte'),
                         ('1004', 'Interneti'),
                         ('1005', 'Bazat e te dhenave'),
                         ('1006', 'Komunikimi Njeri Kompjuter '),
                         ('1007', 'Programimi ne Internet'),
                         ('1008', 'Rrjetat Kompjuterike'),
                         ('1009', 'Siguria e te dhenave'),
                         ('1010', 'Arkitektura e kompjutereve'),
                         ('1011', 'Menaxhimi i projekteve');

INSERT INTO classroom VALUES
                          ('1'),
                          ('2'),
                          ('3');

INSERT INTO City VALUES
                     ('2', 'Mitrovice', 'Kosove', '10000'),
                     ('3', 'Pejë', 'Kosove', '20000'),
                     ('4', 'Prizren', 'Kosove', '30000'),
                     ('5', 'Ferizaj', 'Kosove', '40000'),
                     ('6', 'Gjilan', 'Kosove', '50000'),
                     ('7', 'Gjakovë', 'Kosove', '60000');

create view ten(ten)as
select count(*) from Grades where finalGrade = 10;

create view nine(nine)as
select count(*) from Grades  where finalGrade = 9;

create view eight(eight)as
select count(*) from Grades  where finalGrade = 8;

create view seven(seven)as
select count(*) from Grades where finalGrade = 7;

create view six(six)as
select count(*) from Grades  where finalGrade = 6;

create view five(five)as
select count(*) from Grades where finalGrade = 5;

CREATE VIEW piechart(ten,nine,eight,seven,six,five) AS
SELECT ten,nine,eight,seven,six,five
FROM ten,nine,eight,seven,six,five;

SELECT * FROM piechart;


