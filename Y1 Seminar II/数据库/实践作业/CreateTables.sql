create table G_ROUTETYPE
(
	ROUTETYPE number(5) not null
		constraint G_ROUTETYPE_PK
			primary key ,
	ROUTETYPENAME varchar2(20),
	ROUTETYPEENO varchar2(10)
)
/

comment on table G_ROUTETYPE is '线路类别表'
/

comment on column G_ROUTETYPE.ROUTETYPE is 'pk'
/

comment on column G_ROUTETYPE.ROUTETYPENAME is '线路类别名称'
/

comment on column G_ROUTETYPE.ROUTETYPEENO is '线路类别字母代号'
/

create table G_ROUTENUM
(
	ROUTENUM varchar2(14) not null
        constraint G_ROUTENUM_PK
            primary key ,
	ROUTENAME VARCHAR2(50),
	ROUTETYPE NUMBER(5),
	ROUTESEQ NUMBER(5),
	FICNUM VARCHAR2(6),
	INCOMCOEF NUMBER(3,2) default 1,
	ROUTEFEE NUMBER(4,2) default 01,
	MILEPERCIRCLE NUMBER(6,2),
	ROUTEBUSTYPE VARCHAR2(2)
)
/

comment on table G_ROUTENUM is '线路表'
/

comment on column G_ROUTENUM.ROUTENUM is '线路代号'
/

comment on column G_ROUTENUM.ROUTENAME is '线路名称'
/

comment on column G_ROUTENUM.ROUTETYPE is '线路类别'
/

comment on column G_ROUTENUM.ROUTESEQ is '线路类别序号'
/

comment on column G_ROUTENUM.FICNUM is 'IC卡系统编号'
/

comment on column G_ROUTENUM.INCOMCOEF is '1.03'
/

comment on column G_ROUTENUM.ROUTEFEE is '线路票价'
/

comment on column G_ROUTENUM.MILEPERCIRCLE is '单圈营运里程数'
/

comment on column G_ROUTENUM.ROUTEBUSTYPE is '线路车辆类型'
/

create table G_UNITNUM
(
	UNITNUM VARCHAR2(14) not null
		constraint G_UNITNUM_PK
			primary key ,
	UNINAME VARCHAR2(64),
	RESPEMPLNUM VARCHAR2(10),
	SYMBOL VARCHAR2(1),
	MAINTTYPENUM NUMBER(2),
	QUERYTYPE NUMBER(2),
	PARENTNUM VARCHAR2(14)
)
/

comment on table G_UNITNUM is '单位基本情况表'
/

comment on column G_UNITNUM.UNITNUM is '单位代号'
/

comment on column G_UNITNUM.UNINAME is '单位名称'
/

comment on column G_UNITNUM.RESPEMPLNUM is '负责人工号'
/

comment on column G_UNITNUM.SYMBOL is '标志'
/

comment on column G_UNITNUM.MAINTTYPENUM is '维修护理类别'
/

comment on column G_UNITNUM.QUERYTYPE is '单位查询类别'
/

comment on column G_UNITNUM.PARENTNUM is '父单位节点编号'
/




-- 联合主键

create table G_DICINFO                                                           
(                                                                                
	DICNAME VARCHAR2(20) not null,                                               
	CODE VARCHAR2(20) not null,                                                  
	VALUE VARCHAR2(40),                                                          
	INVALID NUMBER(1) not null,                                                  
	PARAM VARCHAR2(50)                                                           
)                                                                                
/                                                                                
                                                                                 
comment on table G_DICINFO is '字典表'                                              
/                                                                                
                                                                                 
comment on column G_DICINFO.DICNAME is '字典名称'                                    
/                                                                                
                                                                                 
comment on column G_DICINFO.CODE is '条目代码'                                       
/                                                                                
                                                                                 
comment on column G_DICINFO.VALUE is '条目值'                                       
/                                                                                
                                                                                 
comment on column G_DICINFO.INVALID is '有效性 : 1 无效 0 有效'                         
/                                                                                
                                                                                 
comment on column G_DICINFO.PARAM is '额外参数'                                      
/                                                                                
                                                                                 
ALTER TABLE G_DICINFO add constraint G_DICINFO_PK primary key (DICNAME,CODE);    
