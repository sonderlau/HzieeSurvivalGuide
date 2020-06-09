----------------------------------------------------------------------

--  P102 10

Create table student
(
    Sno   char(7) primary key,
    Sname varchar(20)         not null,
    Ssex  char(2) default '男' not null check (Ssex in ('男', '女')),
    Sage  smallint check (sage < 65 and sage > 14),
    Clno  char(5)             not null
)

------------------------------

alter table Course add primary key(Cno);

alter table Course add constraint PK_course primary key (Cno);

alter table Course add constraint check_credit check ( Credit in (1,2,3,4,5,6) );

------------------------------

alter table Class add primary key (Clno);

alter table class add check ( "NUMBER" > 1 and "NUMBER" <100 );

alter table class add foreign key (Monitor) references Student(Sno);

------------------------------

alter table student add foreign key (Clno) references Class(Clno);

------------------------------

alter table Grade add primary key (Sno,Cno);

alter table Grade add foreign key (Cno) references Course(Cno);

alter table Grade add constraint check_mark check ( Gmark >= 0 and Gmark <= 100 );