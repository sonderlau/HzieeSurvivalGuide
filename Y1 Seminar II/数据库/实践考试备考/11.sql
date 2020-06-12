-- -----------------------------------------------------------------------------------

-- 11


-- (1) 增加属性 Nation Varchar(20)
alter table Student add Nation varchar(20);
-- (2) 删除新增的属性
alter table Student drop column Nation;
-- (3) 插入记录
insert into Grade(sno, cno, gmark) VALUES ('2001110','3',80);
-- (4) 修改学号为指定学号的学生的成绩
update grade set Gmark = 70 where Sno = '2001110';
-- (5) 删除学号为指定学号的学生的成绩记录
delete from grade where Sno = '2001110';
-- (6) 在学生表的 Clno 属性上创建 ix_class 的索引 班级号升序排列
create index ix_class
on Student(Clno asc );
-- (7) 删除索引
drop index Student.ix_class;