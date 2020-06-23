 # SQL 语言初步

---

## SQL 简介

`Structured Query Language` 结构化查询语言

核心功能主要有以下几类

- Data Definition Language
  - 数据定义语言
  - 负责创建 修改 删除表 索引和视图等对象
  - `create alter drop`
- Data Manipulation Language
  - 数据操作语言
  - 负责数据的插入 修改 查询和删除操作
  - `insert update select delete`
- Data Control Language
  - 数据控制语言
  - 授予和撤销用户对数据的操作权限
  - `grant revoke`



各个厂商实际使用的SQL语言不尽相同 主要是为了保持自己的竞争力



## 基本数据定义

### 创建基本表

```sql
create table table_name
(
	-- column_definition
);
```

- `table_name`
  - 表名
  - 特别注意 尽量不要使用数据库的关键字
  - 如必要 使用双引号将关键字的名字包括起来 `"DATA"`
- column_definition
  - 每个属性列的定义
  - `<`
  - `<列名><数据类型>[<默认值>|<标识列设置>][<该列的完整性约束>]`
  - `<列名>`
    - 不能重复
  - `<数据类型>`
    - int smallint decimal flopat char varchar() datetime
  - `<默认值>`
    - `default 常量表达式`
  - `<该列的完整性约束>`
    - not null / null / unique



### 表的结构修改

```sql
alter table table_name
[add <列名><数据类型>[列的完整性约束] ] | [add 表的完整性约束]
[alter column <列名><新的数据类型>]
[drop column <列名>]
[drop constraint <表的完整性约束>]
```



#### 删除基本表

```sql
drop table <table_name_1> [, <table_name_2>];
```



#### 创建索引

在一个基本表上 可以建立若干的索引 索引的建立是帮助加快查询速度

**索引的建立和删除工作由DBA或表的拥有者 `dbowner`负责**

用户在查询的时候不能选择索引 选择索引是由 DBMS 自动进行的

```sql
create [unique][clustered][nonclustered] index <index_name>
on <index_name | view_name> (columns...)
```

- `columns...` 
  - 每个指定好的列后面都要指定 `ASC or DESC` 默认是`ASC`
- `unique`
  - 对应数据来源中 唯一的记录 可以有`null` 但是不能有多个`null`
- `clustered`
  - 规定此索引为聚簇索引 一个表或者视图只能有一个聚簇索引
  - 建立聚簇索引后 表在磁盘中的物理存储顺序将与聚簇索引中的一致
  - 在经常查询的列上建立可以加快查询速度
  - 在经常更新的列上建立会增加维护索引的成本
- `nonclustered`
  - 非聚簇索引 这是默认选项



#### 删除索引

建立索引是为了加快查询速度 但是若对表中的数据增删改频繁 系统需要花更多的时间对索引进行维护 降低了效率 因此 要删除不必要的索引

```sql
drop index <index_name_1> [,<index_name_2>];
```



### 基本的数据操作

#### insert

```sql
insert into <table_name> [(column_names)]
values [(value_list)];
```



#### update

```sql
update <table_name>
set <column_name> = <experission> [,<column_name> = <experission>...]
[where <condition>]
```



#### delete

```sql
delete from <table_name>
[where <condition>]
```



## 数据查询

```sql
select [distinct / all] <目标表达式 [[as] 别名] 清单>
```

- `distinct / all`
  - 是否消去查询结果中的重复结果
  - 默认是`all` 全部显示查询结果
- `<目标表达式>`
  - 即查询目标的所要呈现出来的样子



### 带条件的单查询

在上述查询语句中的后面添加

```sql
from <relation_name>
where <conditions>
```

- 特殊运算符号
  - `in` 
  - `not in`
  - `between ... and ...`
  - `not between ... and ...`
  - `like`
  - `not like`



### 分组查询

```sql
group by <column_list> [having <condition>];
```



**`where` 与 `having` 的区别**

- 作用条件不同
  - `where`用于基本表和视图 选择满足条件的元组
  - `having` 作用域分组后的组 选择满足条件的组
- 执行时间不同
  - 先执行`where` 
  - `group by`
  - 再执行`having`
- 聚合函数使用情况不同
  - `where`子句中不可使用聚合函数
  - `havin`子句可以使用聚合函数



### 排序查询

```sql
order by <column_list [ASC / DESC]>
```

**`order by` 只会作用与查询结果的显示**



### 多联系查询

#### 交叉连接 Cross Join

在`from`中的子句中定义 使用`,`区分开

```sql
select e.Name , e.Title , d.Dno , d.Name
from Employee e, Department d
```



#### 内部连接 Inner Join

在`from`子句中定义

```sql
select e.Name , e.Title , d.Dno , d.Name
from Employee e INNER JOIN Department d
on e.Dno = d.Dno;
```

**连接的属性名不一定要求相同 但是数据类型要兼容**



#### 外部连接 Outer Join

- 左外连接 `left join`
  - 除了返回两表中满足连接条件的元组外
  - 还返回左侧表中不匹配元组 右侧表中以 `null` 代替
- 右外连接 `right join`
  - 除了返回两表中满足连接条件的元组外
  - 还返回右侧表中不匹配元组 左侧表中以 `null` 代替
- 全外连接 `full join`
  - 除了返回两表中满足连接条件的元组外
  - 还返回左侧表中不匹配元组 右侧表中以 `null` 代替
  - 还返回右侧表中不匹配元组 左侧表中以 `null` 代替

与自连接`inner join` 类似 只需要改成对应的名称





#### 自身连接 Self Join

```sql
select emp1.Eno,emp2.Emgr
from Employee emp1, Employee emp2
where emp1.Emgr = emp2.Eno
```



### 嵌套查询

即在 `where`中使用另外一个查询的结果

#### 使用 in

#### 使用 > < <> 等

#### 使用 between

#### 相关子查询

上述的情况 大多是子查询只用一次 作为父查询的`where`条件所用 称为 **不相关子查询**

有的查询中 子查询的执行依赖于父查询的某些条件 子查询将不只执行一次

```sql
select Ename
from Employee emp1
where age > 
(
	select avg(age)
    from Employee emp2
    -- 注意下面这句中 值的来源
    where emp2.Dno = emp1.Dno
)
```



一般 也会用 `exists`关键字 用于反馈相对应的查询条件是否查询到了内容



### 含有子查询的数据更新

#### insert 与子查询

将查询结果插入到表中

```sql
insert into table_name [columns]
(sub_select);
```



#### update 与子查询

```sql
update table_name
set clomun_name = expression
[where <sub_select>]
```



#### delete 与子查询

```sql
delete from <table_name>
[where <sub_select>];
```



## 视图

一个视图是从一个或多个关系中导出的关系

数据库只有此视图的定义 没有实际生成此表 **视图是虚表**

- 由于是虚表 一般不建立索引 但是可以建立索引的视图
- SQL一般不提供修改视图定义的语句
  - 如果有需要 删除之后从新定义一个即可 不影响数据
- 对数据中数据进行更新是有限制的



### 视图的定义

```sql
create view view_name [column_list]
as <sub_select>
[with check option];
```

- `with check optiom`
  - 对此视图进行`insert update delete`操作时系统将检查是否符合元定义视图子查询中的条件表达式
- `sub_select`
  - 合法的`select`语句
  - 语句执行后 视图只是进入了数据字典 但是 子查询并未进行
  - 只有在查询视图的时候 才会执行子查询



### 删除视图

```sql
drop view view_name;
```



### 视图的查询

#### 用户

用户查询时 视图和基本表之间是没有区别的 也不能进行区分

用户吃也不需要进行区分



#### DBMS 对视图查询的处理

- 从数据字典中取出该视图的定义
- 把视图定义的子查询和本`select`查询相结合 生成等价的基本表的查询
- 执行对基本表的查询
- 将查询结果对用户显示



### 视图的更新

#### 含义和过程

实质上是由 DBMS 转换成对基本表的数据操作



#### with check option

若加上子句 `with check option` 则对视图更新的时候 会检查原定义时的条件是否满足





#### 视图的可更新性

不是所有的视图都可以更新的

- 有些视图在理论上是不能被更新 如建立年龄和姓名的视图 是不能修改性别的
- 在理论上可以更新 但是特征复杂 实际上还是不能更新的 称为 **不允许更新的视图**



### 视图的作用

- 视图能方便用户操作
- 视图可对数据提供安全保护
- 视图能使不同用户都能用自己喜欢的方式看待同一数据

缺点是 在更新时会有问题 因此也要提前准备好这一点

