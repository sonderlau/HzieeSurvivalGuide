insert all
into G_ROUTETYPE values (1,'普通','P') into G_ROUTETYPE values (2,'空调','K')
into G_ROUTETYPE values (3,'游车','Y') into G_ROUTETYPE values (4,'校车','X')
into G_ROUTETYPE values (5,'假日','JR') into G_ROUTETYPE values (6,'假夜','JY')
into G_ROUTETYPE values (7,'假夜空调','JYK') into G_ROUTETYPE values (8,'其他','QT') select 1 from DUAL;


insert all
into G_ROUTENUM(ROUTENAME,ROUTETYPE,ROUTESEQ,FICNUM,ROUTENUM,ROUTEBUSTYPE) values ('13',1,13,'13','020113','1')
into G_ROUTENUM(ROUTENAME,ROUTETYPE,ROUTESEQ,FICNUM,ROUTENUM,ROUTEBUSTYPE) values ('K13',2,13,'2013','02012013','1')
into G_ROUTENUM(ROUTENAME,ROUTETYPE,ROUTESEQ,FICNUM,ROUTENUM,ROUTEBUSTYPE) values ('K20',2,20,'2020','02012020','1')
into G_ROUTENUM(ROUTENAME,ROUTETYPE,ROUTESEQ,FICNUM,ROUTENUM,ROUTEBUSTYPE) values ('20',1,20,'20','020120','1')
select 1 from dual;


insert all
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('00','公交总公司','1','00000000')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('0001','七堡工段','2','00')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('01','第一汽车修理分公司','1','00')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('02','汽车二公司','1','00')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('0201','二公司一车队','4','02')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('020113','13','6','0201')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('020120','20','6','0201')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('02012013','K13','6','0201')
into G_UNITNUM(UNITNUM,UNINAME,SYMBOL,PARENTNUM) values ('02012020','K20','6','0201')
select 1 from DUAL;


insert all
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','1','公司','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','2','工段','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','3','班组','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','4','车队','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','5','部门','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('UNITTYPE','6','线路','0')

into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('ROUTEBUSTYPE','0','大公共','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('ROUTEBUSTYPE','1','小公共','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('VALIDTYPE','1','无效','0')
into G_DICINFO(DICNAME,CODE,VALUE,INVALID) VALUES ('VALIDTYPE','0','有效','0')
select 1 from DUAL;