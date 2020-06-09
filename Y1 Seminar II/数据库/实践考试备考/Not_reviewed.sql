# Sorted by Sonder_Lau
# Last modified : 2020 / 5 / 23


# 建表
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
    Credit smallint

);

create table Class
(
    Clno char(5) primary key ,
    Speciality varchar(20) not null ,
    Inyear char(4) not null ,
    Number INTEGER ,
    Monitor char(7)
);



create table Grade
(
  Sno char(7) not null references student(Sno),
  Cno char(1) not null references course(Cno),
  Gmark numeric,
  # 此处是SQL Server的写法 如果是Oracle 需要写成
  # !  Gmark number
  primary key (Sno,Cno)
);


# -----------------------------------------------------------------------------------

# 插入信息部分
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


INSERT INTO class(clno,speciality,inyear,number,monitor)
    VALUES('00311','计算机软件','2000',120,'2000101');

INSERT INTO class(clno,speciality,inyear,number,monitor)
    VALUES('00312','计算机应用件','2000',140,'2000103');

INSERT INTO class(clno,speciality,inyear,number,monitor)
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

# -----------------------------------------------------------------------------------

# 11
 

# (1)
alter table Student add Nation varchar(20);
# (2)
alter table Student drop Nation;
# (3)
insert into Grade(sno, cno, gmark) VALUES ('2001110','3',80);
# (4)
update grade set Gmark = 70 where Sno = '2001110';
# (5)
delete from grade where Sno = '2001110';



# (5) 在学生表的 Clno 属性上创建 ix_class 的索引 班级号升序排列
# TBD
# (6) 删除索引
# TBD


# -----------------------------------------------------------------------------------

# 12



# )1
select distinct Cno
    from grade;
# )2
select *
    from student
    where Clno = '01311' and Ssex = '女';
# )3
select Sname,Ssex,2020-Sage as birth
from student
where Clno = '01311' or Clno = '01312';

# )4
select *
from student
where Sname like '李%';

# )5
select count(*) from Student
where Clno in (select Clno from student where Sname = '李勇');

# )6
select min(Gmark), avg(Gmark), max(Gmark)
from grade,course
where Course.Cname = '操作系统' and Course.Cno = Grade.Cno;

# )7
select count(distinct Sno)
from grade;

# )8
select count(*)
from grade,course
where Course.Cname = '操作系统' and course.Cno = Grade.Cno;

# )9
select Sname
from student
where Clno in (
    select Clno
        from class
    where Inyear = '2000' and Speciality = '计算机软件' and Student.Sno in (
        select Sno
        from grade
        where Gmark is null
        )
    );


# -----------------------------------------------------------------------------------

#  13


# )1
select *
from student s1,student s2
where s2.Sname = '李勇' and s1.Clno = s2.Clno;
# )2
select * from student where sno in (
    select sno from grade where Cno in (
        select cno from grade ,student
            where student.Sno = Grade.Sno and Student.Sname = '李勇'
        )
    )
and Sname != '李勇';

# )3
select * from student
where sage between (select Sage from student where Sname='李勇') and 25;

# )4
select Sno , Sname
from student where Sno in (
    select sno from grade,course
    where course.Cname = '操作系统' and grade.cno = Course.Cno and Grade.Gmark is not null
    );

## 与标准答案不太一样 这里我排除了成绩为空的学生 我觉得这样不算选修成功

# )5
select Sname
from student
where sno not in (
    select sno from grade
    where Cno = '1'
    );


# )6
select Sname from student
where 
	(
	select count(cno) from grade 
	group by Grade.Sno
	) = 
	(
	select count(*) from course
	);


# 14

	# 1)
select Sno,Gmark from Grade where Cno =  '3' order by Gmark desc;

	# 2)
select * from student order by Clno asc,Sage desc;

	# 3)
select distinct clno, count(Sno) as '选课人数' from grade group by Cno;
	# 4)
select Sno, count(Cno) as '选课门数' from grade
group by Sno
having count(Cno) > 3;

	
# 15

	# 1)
update grade set Gmark = 0 where Sno in 
	(
	 select Sno from student where Clno = '01311'
);

	# 2)
delete from grade where Sno in 
	(
		select Sno from Student where Clno = '01311'
		
		);
	# 3)
		# 删除顺序  :  Grade -> class -> Student

delete from grade where Sno in 
	(
		select sno from student
		where Sname = '李勇'
		);


update class set number = number -1
where clno in 
(
	select clno from student
	where Sname = '李勇'
);


delete from student where Sname = '李勇';

	# 4)

create table average
	(
		clno char(5),
		average smallint

		);

insert into average select clno,avg(sage) from student group by clno;