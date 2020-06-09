-- -----------------------------------------------------------------------------------

-- 12


-- (1) 找出所有被学生选修了的课程号
-- 不重复
select distinct Cno
from grade;

-- (2) 找出 01311班 女 学生的个人信息
select *
from student
where Clno = '01311'
  and Ssex =  '女';

-- (3) 找出 01311 01312班 的学生姓名 性别 出生年份
select Sname, Ssex, 2020 - Sage as birth
from student
where Clno = '01311'
   or Clno = '01312';

-- (4) 找出所有姓李的学生的信息
select *
from student
where Sname like '李%';

-- (5) 找出李勇所在班级的学生人数
select count(*)
from Student
where Clno in
      (select Clno
       from student
       where Sname = '李勇');

-- (6) 找出 操作系统 课程的平均成绩 最高分 最低分
select min(Gmark), avg(Gmark), max(Gmark)
from grade,
     course
where Course.Cname = '操作系统'
  and Course.Cno = Grade.Cno;

-- (7) 选修了课程的学生人数
select count(distinct Sno)
from grade;

-- (8) 找出选修了 操作系统 课程的学生人数
select count(*)
from grade,
     course
where course.Cname = '操作系统'
  and course.Cno = grade.Cno;

-- (9) 找出 2000 级 计算机软件班的成绩为空的学生姓名
select Sname
from student
where Clno in (
    select Clno
    from class
    where Inyear = '2000'
      and Speciality = '计算机软件'
      and Student.Sno in (
        select Sno
        from grade
        where Gmark is null
    )
);
