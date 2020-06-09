------------------------------------------------------------------

-- 14

-- (1) 查询选修了 3号课程的学生 学号及其成绩 并按成绩降序排列
select Sno, Gmark
from Grade
where Cno = '3'
order by Gmark desc;

-- (2) 查询全体学生信息 要求查询结果按班级号升序排列 同一班级学生按年龄降序排列
select *
from student
order by Clno asc, Sage desc;

-- (3) 求每个课程号及对应的选课人数
select Cno, count(Sno) as "选课人数"
from grade
group by Cno;

-- (4) 查询选修了 3门 以上课程的学生学号
select Sno
from grade
group by Sno
having count(Cno) > 3;
