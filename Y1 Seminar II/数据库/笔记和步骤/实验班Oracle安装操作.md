# 数据库

---

[TOC]



## 手动创建数据库

安装数据库时 在安装选项里面 请选择 **仅安装数据库软件**

### 编写初始化参数文件

- 使用Oracle已经提供的初始化参数文件样本 并在这个参数文件样本的基础上修改
  - 路径:
    - %ORACLE_HOME%\admin\sample\pfile
    - %ORACLE_HOME%\dbs
  - 默认文件位置
    - %ORACLE_HOME%\database
  - 默认文件名
    - spfile %ORACLE_SID%.ora  二进制
    - init%ORACLE_SID%.ora       文本

#### 新增参数

```
# 实例名
Instance_name = YourOracleName
# 数据库域名
db_domain = hdu.edu.cn
```

#### 修改参数

```
# 数据库名
db_name = YourOracleName
# 数据块的大小(字节) 创建后无法更改
Db_block_size = 8192
# 允许非SYS用户以SYSDBA身份管理数据库 修改SYS的密码
Remote_login_passwordfile = exclusive
```

设置**系统环境变量**

`oracle_sid = 实例名`

### 创建实例和口令文件

```
oradim -new -sid DDD -intpwd sys123 -startmode auto
```

> `-new` 新建实例
>
> `-sid` 实例名称
>
> `-intpwd` 指定sys用户的口令
>
> `-startmode` 指定启动实例的方式
>
> `auto` 自动启动实例

### 生成服务器参数文件 `spfile`

```
SQL> create spfile from pfile;
```

### 创建数据库

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

因为此时还未创建实例 需要使用`nomount` 启动

有关`startup` 的参数等 参考下面的内容

### 英文提示

为了避免乱码等情况的出现 使用注册表的内容改变语言

`regedit`

路径 

> `HKEY_LOCAL_MACHINE \ SOFTWARE \ ORACLE \ KEY_OraDb11g_home1    `

将 `NLS_LANG`中的值改为 `AMERICAN_AMERICA.ZHS16GBK`



在C盘下创建目录 `db`

执行

```sql
create database DDD
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

- 实例名 `DDD`
- `datafile`
  - SYSTEM 表空间 : 数据文件 `system_o1.dbf`
  -  SYSAUX 表空间  : 辅助数据文件 `systemaux_01.dbf`
- `logfile` 设定重做日志文件组和成员
  - 两个组 每组各一个
- `undo tablespace`
  - 创建撤销表空间`UNDOTBS11` 管理`UNDO` 数据
- `character set` 数据库保存数据的字符集
- `national character set` 字符集

如果你上述执行命令中 有错误 如输入有误等 参考如下措施

> `shutdown`
>
> 删除`database`下的控制文件 
>
> 删除自己创建的`db`目录下的所有文件
>
> `conn sys/sys123 as sysdba` 登陆
>
> `startup nomount` 启动数据库
>
> 再来一次

###  运行脚本

以下地址不唯一 请参考 `%ORACLE_HOME%` 的地址

``` 
SQL> @ C:\app\Administrator\product\11.2.0\dbhome_1\RDBMS\ADMIN\catalog.sql
SQL> @ C:\app\Administrator\product\11.2.0\dbhome_1\RDBMS\ADMIN\catproc.sql
```

- `catalog.sql` 创建系统常用的数据字典视图和公有同义词
- `catproc.sql` 创建 `PL/SQL` 功能的使用环境和包 用于扩展`RDBMS` 的功能

需要转换成`system`用户

```
connect system/manager
```

```
SQL> @ C:\app\Administrator\product\11.2.0\dbhome_1\sqlplus\admin\pupbld.sql
```

- `pupbld.sql` 是使用 `SQL*Plus` 环境的需要

#### startup 解析

```
startup [nomount | open | mount]
```

在创建好数据库后 使用`startup open` 启动数据库

##### nomount

只会创建实例 不加载数据库 不打卡任何数据文件

**必须要以 sysdba的身份登陆**

[^nomount]: 通常在创建新数据库或重建控制文件时 使用`nomount`模式启动数据库实例

##### mount

将启动实例 加载数据库并保持数据库的关闭状态

##### open

将启动实例、加载并打开数据库，这是常规的启动模式，用户想要对数据库进行多种操作，就必须使用OPEN模式启动数据库实例

可以后面不加参数 因为这就是`startup`的默认选项

##### force

种模式将终止实例并重新启动数据库，这种启动模式具有一定的强制性。比如，在其他启动模式失效时，可以尝试使用这种启动模式

---

```
shutdown [normal | transactional | immediate | abort]
```

##### transactional

这种方式称作事务关闭方式，它的首要任务是能够保证当前所有的活动事务都可以被提交，并在尽可能短的时间内关闭数据库

##### immediate

这种方式能够在尽可能短的时间内关闭数据库

##### abort

这种方式称作终止关闭方式，终止关闭方式具有一定的强制性和破坏性。使用这种方式会强制中断任何数据库操作，这样可能会丢失一部分数据信息，影响数据库的完整性。除了由于使用其他3种方式无法关闭数据库而使用它之外，应该尽量避免使用这种方式

---

### 网络配置

#### 监听程序配置

> 修改 `listener.ora`
>
> 位于 `%ORACLE_HOME%\NETWORK\ADMIN` 目录下

客户端配置

> 配置网络服务名
>
> 本地命名 `tnsnames.ora` 文件中
>
> 文件位于 `%ORACLE_HOME%\NETWORK\ADMIN` 目录下

以下采用GUI进行配置

使用 Oracle Net Configuration Assistant

1. 选择 **监听程序配置**
2. 添加
3. 自行输入 监听程序名
4. **一般选择 TCP**
5. 端口号默认的就行
6. 否
7. 完成

可在Windows服务中查看对应的服务启动 名字类似于 `OracleOraDb1g_home1TNSListener`

#### 添加数据库到监听程序 并重启

Net Manager

1. 双击**监听程序** 
2. 选择你的监听程序
3. 选择数据库服务
4. 添加数据库
5. 输入全局数据库名 一般为 服务名.域名 eg: `ddd.hdu.edu.cn`
6. 重启监听服务 可在Windows 服务中选择该项服务重启

#### 命名方法的配置

Net Configuration Assistant

1. 命名方法选择 本地命名 轻松连接命名
2. 下一步
3. 完成

#### 客户端网络服务名配置

Net Manager

1. 双击**服务命名**
2. 点击 `+` 或者 编辑 创建
3. 输入自定义的网络服务名 不能与现有的重复
4. 选择 `TCP/IP` 
5. 输入主机名 `localhost` 端口号
6. 服务名 一般为 服务名.域名 eg: `ddd.hdu.edu.cn`
7. 点击测试 查看是否可以链接
8. 如果登陆失败 可以换个账户密码 如 `system / mangaer` 等

---



















## 建立模型

### 概念模型

Entyti-Relationship Model 实体联系模型

- Peter Chen 1976年





















