-- 建表
create table Student
(
	Sno char(7) primary key ,
	Sname varchar(20) not null ,
	Ssex char(2) not null ,
	Sage smallint ,
	Clno char(5) not null
);

create table Course
(
    Cno char(1) primary key ,
    Cname varchar(20) not null ,
    Credit numeric
);

create table Class
(
    Clno char(5) primary key ,
    Speciality varchar(20) not null ,
    Inyear char(4) not null ,
    "NUMBER" INTEGER ,
    Monitor char(7)
);



create table Grade
(
  Sno char(7) not null references student(Sno),
  Cno char(1) not null references course(Cno),
  Gmark numeric,
  primary key (Sno,Cno)
);


-- -----------------------------------------------------------------------------------

-- 插入信息部分
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2000101','李勇','男',20,'00311');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2000102','刘诗晨','女',19,'00311');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2000103','王一鸣','男',20,'00312');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2000104','张婷婷','女',21,'00312');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2001101','李勇敏','女',19,'01311');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2001102','贾向东','男',22,'01311');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2001103','陈宝玉','男',20,'01311');
INSERT INTO Student(Sno,Sname,Ssex,Sage,Clno) VALUES('2001104','张逸凡','男',21,'01311');


INSERT INTO Course(Cno,Cname,Credit) VALUES('1','数据库','4');
INSERT INTO Course(Cno,Cname,Credit) VALUES('2','离散数学','3');
INSERT INTO Course(Cno,Cname,Credit) VALUES('3','管理信息系统','2');
INSERT INTO Course(Cno,Cname,Credit) VALUES('4','操作系统','4');
INSERT INTO Course(Cno,Cname,Credit) VALUES('5','数据结构','4');
INSERT INTO Course(Cno,Cname,Credit) VALUES('6','数据处理','2');
INSERT INTO Course(Cno,Cname,Credit) VALUES('7','C语言','4');


INSERT INTO class(clno,speciality,inyear, "NUMBER",monitor)
    VALUES('00311','计算机软件','2000',120,'2000101');

INSERT INTO class(clno,speciality,inyear, "NUMBER",monitor)
    VALUES('00312','计算机应用件','2000',140,'2000103');

INSERT INTO class(clno,speciality,inyear, "NUMBER",monitor)
    VALUES('01311','计算机软件','2001',220,'2001103');


INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000101','1',92);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000101','3',NULL);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000101','5',86);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000102','1',78);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000102','6',55);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000103','3',65);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000103','6',78);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000103','5',66);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000104','1',54);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2000104','6',83);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001101','2',70);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001101','4',65);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001102','2',80);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001102','4',null);

INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001103','1',83);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001103','2',76);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001103','4',56);
INSERT INTO Grade(Sno,Cno,Gmark) VALUES('2001103','7',88);
