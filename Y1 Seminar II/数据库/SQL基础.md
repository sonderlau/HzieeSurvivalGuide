# SQL 语句 基础

关键字使用大写 变量或者其他数据等 使用小写

---

## 基本使用

### 查询 SELECT

```sql
SELECT [DISTINCT] *| column_list_1 AS DIYname
FROM table_list
[WHERE condition_expression]
[GROUP BY column_list2 [HAVING condition_expression_2]]
[ORDER BY column_list3 [ASC| DESC ]] ;
```

很重要的一个句子 这是展示数据 筛选数据结果的重要语句

- `DISTINCT` 用于删除查询结果中相同的行
- `column_list_1` 是选择数据的列名 后面加上`as`关键字可使用别名
- `FROM` 指明查询对象 表或者视图 此处也可使用别名 **但是不需要使用`as`关键字**
- `WHERE` 指明查询的条件
- `GROUP BY` 分组依据 
  - `HAVING` 进一步限定条件
- `ORDER BY` 指定结果的排序依据 
  - `ASC DESC` 代表是升序或者降序 其中默认的是升序



#### where 的运算符

1. 比较

   > - `= < > != <> !< <= !> >=`
   > - 特殊的有 `ANY SOME ALL`
   > - `ANY SOME` 指的是满足其中一个 单一个的值
   > - `ALL` 所有值

2. 确定范围

   > - `BETWEEN a AND b`
   > - `NOT BETWEEN a AND b` 
   >
   > 判断是不是在$[a,b]$区间内 注意是**闭区间**

3. 确定集合

   > `IN () NOT IN()`
   >
   > 在不在这个集合里面呢

4. 模糊查询

   > `LIKE`
   >
   > `NOT LIKE`

5. 空值

   > `IS NULL`
   >
   > `IS NOT NULL`

   ```sql
   SELECT id FROM stu
   WHERE score IS NOT NULL;
   ```

6. 逻辑比较

   > `AND OR NOT`
   >
   > 用于多重条件判 

TIPS：

> - 字符型 日期型数据 需要使用 **单引号**
> - 日期数据格式敏感  Oracle的默认格式为 `DD-MON-YYYY`
> - 模糊查询
>
>   - `%` 表示0或多个字符
>   - `_` 表示一个字符
>   - `M%` 
>   - `%M%` 
> - `ROWNUM`是个伪列 用来代表结果的行个数



#### GROUP BY 分组

TIPS:

- 空值字段也会当作新的一个分组
- 对于指定的一组只生成一条记录  不返回详细信息
- 对于`SELECT`后面的每一列 除了出现在分组函数中的列意外 都必须包含在`GROUP BY`子句中



#### 连接查询

```sql
FROM table_name_1 [join_type] JOIN table_name_2
[ ON (join_condition)];
```

**TBD**



#### 子查询

即多个`SELECT` 语句嵌套 可增强选择能力

```sql
SELECT id 
FROM stu
WHERE age=(SELECT id 
           FROM life 
           WHERE name='Nice');
```



#### 集合查询

```SQL
SELECT clause_1
[ UNION ALL | UNION | INTERSECT ];
SELECT clasuse_2 ;
```

**TBD**



### 常用函数

#### 数值函数

| Function grammar         | Description                        | Examples              |
| ------------------------ | ---------------------------------- | --------------------- |
| `ABS (value)`            | 绝对值                             | `ABS(-4) = 4`         |
| `CEIL (value)`           | 向上取整                           | `CEIL(9.8)=10`        |
| `FLOOR (value)`          | 向下取整                           | `FLOOR(9.8)=9`        |
| `SQRT (value)`           | 返回平方根                         | `SQRT(64)=8`          |
| `POWER (value1, value2)` | 返回`value1`的`value2`次方         | `POWER(2,3)=8`        |
| `TRUNC (value1, value2)` | 截取`value1`的`value2`位小数       | `TRUNC(1.567,2)=1.56` |
| `ROUND (value1, value2)` | 对`value1`进行`value2`位的四舍五入 | `ROUND(1.567,2)=1.57` |



#### 聚集函数

| Function Grammar                | Description         |
| ------------------------------- | ------------------- |
| `COUNT(column)` or `COUNT(*)``` | 计算个数 或者总行数 |
| `SUM(column)`                   | 总和                |
| `AVG(column)`                   | 平均值              |
| `MAX(column)`                   | 最大值              |
| `MIN(column)`                   | 最小值              |



#### 空值转换

```sql
NVL (column, value)
```

当`column`列值为空时 返回`value`值 



#### 字符函数

| Function Grammar        | Description                 | Examples                       |
| ----------------------- | --------------------------- | ------------------------------ |
| `ASCII(c)`              |                             |                                |
| `CHR(n)`                |                             |                                |
| `INITCAP(c)`            | 首字母大写                  |                                |
| `LENGTH(c)`             | 长度                        |                                |
| `LOWER(c)`              | 转为小写                    |                                |
| `UPPER(c)`              | 转为大写                    |                                |
| `LTRIM(c1 [,c2])`       | c1左边出现的c2 c2默认为空格 | `LTRIM('aaba','a')='ba'`       |
| `RTRIM(c1 [,c2])`       | c1右边出现的c2 c2默认为空格 | `RTRIM('abaa','a')='ab'`       |
| `REPLACE(c1, c2 [,c3])` | c1中的c2用c3替代            | `REPLACE('abc','bc','d')='ad'` |
| `INSTR(c1, c2)`         | 在c1中找c2                  |                                |
| `SUBSTR(c, m [,n])`     | 截取c1 从m开始到n           | `SUBSTR('abcd',2,2)='bc'`      |
| `LPAD(c1, n [,c2])`     | 在c1左侧填充c2 达到n位      |                                |
| `RPAD(c1, n [,c2])`     | 在c1右侧填充c2 达到n位      |                                |



#### 日期函数

| Function Grammar               | Description                                  |
| ------------------------------ | -------------------------------------------- |
| `ADD_MONTH(date, n)`           | 在date上增加n个月                            |
| `LAST_DAY(date)`               | 返回date所在月份的最后一天                   |
| `NEXT_DAY(date, 'day')`        | 从date开始 下一个周几的日期是多少            |
| `MONTHS_BETWEEN(date1, date2)` | 返回date2 - date1 的月份数                   |
| `SYSDATE`                      | 当前的日期和时间                             |
| `SYSTIMESTAMP`                 | `TIMESTAMP`类型的系统时间 能存储小数部分的秒 |



#####  转换函数

| Function Grammar              | Description                                                  |
| ----------------------------- | ------------------------------------------------------------ |
| `TO_CHAR(date, 'format')`     | 将date按照格式转换为字符串                                   |
| `TO_DATE(c, 'format')`        | 将字符串按照格式转换为日期                                   |
| `TO_NUMBER(n)`                | 将数字字符转换为数值                                         |
| `EXTRACT(Keywords FROM date)` | 抽取数据. Keywords = [`year` | `month` | `day` | `minute` | `second` | `hour`] |

