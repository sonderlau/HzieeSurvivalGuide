----------------------------------------------------------------------

--  P102 10

---------------------------------

alter table Student
add check ( Ssex in ('男','女') );

alter table Student
modify Ssex default '男';

alter table Student
add check ( Sage > 14 and Sage < 65 );

---------------------------------

alter table Class add primary key (Clno);

    -- Oracle 级联更新 不能直接设置 需要通过如下方法

alter table Student add constraint student_class_id foreign key (Clno) references Class(Clno) on delete cascade deferrable ;

    -- 触发器: 当 Class的主键改变时 更新 Student 的 Clno
create or replace trigger TGR_CLASS_UPDATE
    after update of Clno on Class
    for each row
    begin
        if :OLD.Clno <> :new.Clno then
            update Student set Clno = :new.Clno where Clno = :old.Clno;
        end if;
    end;

---------------------------------

alter table Course add primary key (Cno);

alter table Course add check ( Credit in (1,2,3,4,5,6) );

---------------------------------

alter table Class add check ( "NUMBER" > 1 and "NUMBER" < 100 );

alter table Class add foreign key (Monitor) references Student(Sno);

---------------------------------

alter table Grade add foreign key (Sno) references Student(Sno);

alter table Grade add foreign key (Cno) references Course(Cno);

alter table Grade add check ( Gmark > 0 and Gmark < 100 );