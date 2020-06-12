----------------------------------------------------------------------

-- 16

-- (1) 建立 01311 班 选修了 1号 课程的学生视图 Stu_01311_1
create view Stu_01311_1
as
select *
from Student
where Student.Sno in (
    select Sno
    from Grade
    where Grade.Cno = '1'
      and Student.Clno = '00312'
)
;

-- (2) 建立 01311 班 选修了 1号课程 且成绩不及格的学生视图 Stu_01311_2
create view Stu_01311_2
as
select *
from Student
where Student.Sno in (
    select Sno
    from Grade
    where Grade.Cno = '1'
      and Grade.Gmark < 60)
  and Student.Clno = '00312';


-- (3) 建立视图 Stu_year 由 学生学号 姓名 出生年份组成
create view Stu_year
as
select Sno, Sname, 2020-Sage birthyear
from Student;

-- (4) 查询 1990 年以后出生的学生姓名
select Sname
from Stu_year
where birthyear > 1990

-- (5) 查询 01311 班 选修了 1号课程 并且成绩不及格的学生的 学生 姓名 出生年份
select Sname,2020-Sage
from Stu_01311_2;