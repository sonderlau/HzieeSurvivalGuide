# Java Final Review

---



## 语言基础

### 常见关键字

### 命名规范

`A~Z a~z $ 汉字 _`组成

开头不可以是数字



### 数据类型



| 类型   | 名字    | 字节               |
| ------ | ------- | ------------------ |
| 整型   | byte    | 单字节 字节整型    |
|        | short   | 2字节 短整型       |
|        | int     | 4字节 普通整型     |
|        | long    | 8字节 长整型       |
| 字符型 | char    |                    |
| 浮点型 | float   | 4字节 单精度浮点型 |
|        | double  | 8字节 单精度浮点型 |
| 布尔型 | boolean |                    |



| 类型  | 占用字节数 | 取值范围                              |
| ----- | ---------- | ------------------------------------- |
| byte  | 1          | -2<sup>7</sup> ~ (-2<sup>7</sup>-1)   |
| short | 2          | -2<sup>15</sup> ~ (2<sup>15</sup>*1*) |
| int   | 4          | -2<sup>31</sup> ~ (2<sup>31</sup>-1)  |
| long  | 8          | -2<sup>63</sup> ~ (2<sup>63</sup>-1)  |



| 类型   | 字节 | 范围                                                 | 字位数 |
| ------ | ---- | ---------------------------------------------------- | ------ |
| float  | 4    | -3.402823×10<sup>38</sup>~3.402823×10<sup>38</sup>   | 6      |
| double | 8    | -1.797693×10<sup>308</sup>~1.797693×10<sup>308</sup> | 15     |



Java中存储char字符采用的是`Unicode`



| 转义字符 | 含义       |
| -------- | ---------- |
| `\b`     | 退格       |
| `\n`     | 换行       |
| `\r`     | 回车       |
| `\w`     | 十六进制数 |
| `\t`     | 水平制表符 |
| `\\`     | 反斜杠     |



| 转换符 | 说明              |
| ------ | ----------------- |
| `%s`   | 字符串类型        |
| `%c`   | 字符类型          |
| `%b`   | 布尔类型          |
| `%d`   | 整数类型 十进制   |
| `%x`   | 整数类型 十六进制 |
| `%o`   | 整数类型 八进制   |
| `%f`   | 浮点类型          |
| `%a`   | 十六进制浮点类型  |
| `%e`   | 指数类型          |
| `%g`   | 通用浮点类型      |
| `%n`   | 换行符            |



| 标志 | 说明                  |
| ---- | --------------------- |
| `+`  | 正/负数 添加符号      |
| `-`  | 左对齐                |
| `0`  | 补0                   |
| `,`  | 分组                  |
| `(`  | 括号包括负数 去掉负号 |



## 控制流程语句

### switch

```java
switch(judge){
   case 1 : break;
   default : break;
}
```

**judege** : 

>  不可以是 `long float double boolean`

**case** :

>  后面接常量表达式



### do while

```java
do {循环体}
while(){}
```

循环体**至少**执行一次



### break continue

通过label 可以指定循环结构体

```java
Nice:
for (){}
while(){continue Nice; break Nice;}
```



## 查找 排序

### 顺序查找

### 二分查找

>  **需要已经排序好数组**
>
>  先找中间 如果正确则结束
>
>  与中间值的大小进行比较 递归 前 / 后 子数组

```java
	 /*
     * 默认升序排列好
     */
    public static boolean binarySearch(int[] nums,int start,int end,int num){
        int middle = (start + end )/2;
        if (num == nums[middle]){
            return true;
        }
        if (num > nums[middle]){
            return binarySearch(nums,middle+1,end,num);
        }else {
            return binarySearch(nums,start,middle-1,num);
        }
    }
```



### 选择排序

>  先找最小 放到开头
>
>  找第n小的数 与第n位的数交换

```java
int minIndex;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                // swap num
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
```



### 冒泡排序

>  从n=0开始 每相邻的两个数比较大小进行交换
>
>  n=1 .....

```java
for (int i = 0; i < nums.length ; i++){
   for (int j=0 ; j <nums.length ; j++){
      if (nums[j] > nums[j+1]){
         // swap
         int temp = nums[j];
         nums[j] = nums[j+1];
         nums[j+1] = temp;
      }
   }
}
```



## 类与对象

创建

```java
类名 对象变量名 = new 类名();
Shuai wo = new Shuai();
```



### 方法重载

### 方法重写

|                   | 方法名 | 参数列表             | 返回值类型 | 修饰符                   | 定义位置 |
| ----------------- | ------ | -------------------- | ---------- | ------------------------ | -------- |
| **重载 Overload** | 相同   | 不同(个数或对应类型) | 无关       | 无关                     | 同一个类 |
| **重写 Override** | 相同   | 相同                 | 相同       | 访问权限不小于被重写方法 | 子父类中 |



### static

静态方法内部只能使用静态的成员变量 不能访问类的非静态成员

访问不需要创建对象就可以直接调用



## 类的继承

```java
public class Apple extends Fruit{}
```

#### 覆盖父类方法

>  覆盖要求 **方法名称 返回值得类型 传入参数得个数和类型完全一致**

#### 重载父类方法



### super

>  Java中 子类得构造方法必须以一定方式调用父类得构造方法

若默认不进行调用 则编译器会自动调用父类的无参构造方法



### 访问权限修饰符(public/private/default/protected)

|           | 本类 | 本包 | 子类 | 其他类 |
| --------- | ---- | ---- | ---- | ------ |
| private   | Y    |      |      |        |
| 默认      | Y    | Y    |      |        |
| protected | Y    | Y    | Y    |        |
| public    | Y    | Y    | Y    | Y      |

>  **private : 强调给自己使用 属性**
>
>  **默认 : 强调给同包下的来使用** 
>
>  **protected : 强调给子类使用 会被子类继承的方法**
>
>  **public : 强调给大家使用 方法**    



### abstract 抽象

```java
public abstract String getType(){}
abstract class Name{}
```

如果一个类中包含抽象方法 则该类必须是抽象类

抽象类不能被实例化 一般作为其他类的父类 



### interface 接口

```java
public interface InterfaceName extends FatherInterface{}
```

修饰符可以是`public` 也可是` ` 空缺

接口体中的变量只能定义为`static` 和 `final`

如果一个接口是从别的一个或多个父接口中继承而来，则在类体中必须加入实现该接口及其父接口中所有方法的代码

在实现一个接口时 类中对方法的定义要和接口中的相应的方法的定义相匹配，其方法名 方法的返回值类型 方法的访问权限和参数的数目与类型信息要一致



---

## 异常的处理

在编译阶段的语法问题会被处理 运行时出现的情况和错误成为 **异常 Exception**

**Exception / Error**

都是**Throwable**的子类



结构处理

`try-catch-finally`进行处理

 

---

## 重要例子

### 欧几里得求解gcd

递归

```java
public static int solveGcd(int max, int min){
   if (min == 0){
      return max;
   }
   return solveGcd(min , max % min);
}
```

迭代

```java
public static int solveGcd(int max , int min){
   while(min != 0){
      int temp = min;
      min = a % b;
      max = temp;
   }
   return max;
}
```

