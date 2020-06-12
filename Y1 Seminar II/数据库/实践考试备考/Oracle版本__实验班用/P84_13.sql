--------------------------------------------------------------------------------------

--  13


-- (1) 找出与李勇在同一个班级的学生信息
select *
from student s1,
     student s2
where s2.Sname = '李勇'
  and s1.Clno = s2.Clno;
-- (2) 找出所有与学生李勇有相同选修课程的学生信息
select *
from student
where sno in (
    select sno
    from grade
    where Cno in (
        select cno
        from grade,
             student
        where student.Sno = Grade.Sno
          and Student.Sname = '李勇'
    )
)
  and Sname != '李勇';

-- (3) 
select *
from student
where sage between (select Sage from student where Sname = '李勇') and 25;

-- (4)
    -- 与标准答案不太一样 这里我排除了成绩为空的学生 我觉得这样不算选修成功
select Sno, Sname
from student
where Sno in (
    select sno
    from grade,
         course
    where course.Cname = '操作系统'
      and grade.cno = Course.Cno
      and Grade.Gmark is not null
);



-- (5) 找出没有选修 1号课程的所有学生姓名
select Sname
from student
where sno not in (
    select sno
    from grade
    where Cno = '1'
);


-- (6) 找出选修了全部课程的学生姓名
select Sname
from student
where (
          select count(cno)
          from grade
          group by Grade.Sno
      ) =
      (
          select count(*)
          from course
      );
