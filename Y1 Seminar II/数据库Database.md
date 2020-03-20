# 数据库

---

安装数据库时 在安装选项里面 请选择 **仅安装数据库软件**



编写初始化参数文件

- 使用Oracle已经提供的初始化参数文件样本 并在这个参数文件样本的基础上修改
  - 路径:
    - %ORACLE_HOME%\admin\sample\pfile
    - %ORACLE_HOME%\dbs
  - 默认文件位置
    - %ORACLE_HOME%\database
  - 默认文件名
    - spfile %ORACLE_SID%.ora  二进制
    - init%ORACLE_SID%.ora       文本

编写初始化参数文件
新增参数

```
Instance_name = YourOracleName
Db_domain = hdu.edu.cn
```

修改参数

```
Db_name = YourOracleName
Db_block_size = 8192
Remote_login_passwordfile = exclusive
```

设置系统环境变量

`oracle_sid = orcl`



创建实例

- oradim 的使用
- `oradim -new -sid YourOracleName -intpwd sys123 -startmode auto`



创建数据库

打开cmd







```sql
sqlplus /nolog
```



```sql
conn sys/sys123 as sysdba
```



```
startup nomount
```





修改注册表

`regedit`

路径 `HKEY_LOCAL_MACHINE \ SOFTWARE \ ORACLE \ KEY_OraDb11g_home1    `

将 `NLS_LANG`中的值改为 `AMERICAN_AMERICA.ZHS16GBK`



在C盘下创建目录 `db`



```sql
create database YourOracleName
datafile
	'C:\db\system_01.dbf' size 180m
	autoextend on next 10m maxsize unlimited
sysaux datafile
	'C:\db\systemaux_01.dbf' size 80m
	autoextend on next 10m maxsize unlimited
logfile
	group 1 ('C:\db\log_1_01.rdo') size 10m,
	group 2 ('C:\db\log_2_01.rdo') size 10m
undo tablespace UNDOTBS1
datafile 'C:\db\undo01.dbf' size 20M
character set zhs16gbk
national character set AL16UTF16;
```

