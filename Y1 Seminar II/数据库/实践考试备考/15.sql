----------------------------------------------------------------------

-- 15

-- (1) 将 01311 班全体学生成绩置 0 
update grade
set Gmark = 0
where Sno in
      (
          select Sno
          from student
          where Clno = '01311'
      );

-- (2) 删除 2001 级 计算机软件的全体学生的选课记录
delete
from grade
where Sno in
      (
          select Sno
          from Student
          where Clno = '01311'
);


-- (3) 在数据库中删除李勇有关的记录
		-- 删除顺序  :  Grade -> class -> Student

delete
from grade
where Sno in
      (
          select sno
          from student
          where Sname = '李勇'
      );


update class
set "NUMBER" = "NUMBER" - 1
where clno in
      (
          select clno
          from student
          where Sname = '李勇'
      );


delete
from student
where Sname = '李勇';



-- (4) 对每个班 求学生的平均年龄 存入数据库
create table average
(
    clno    char(5),
    average smallint
);

insert into average
select clno, avg(sage)
from student
group by clno;