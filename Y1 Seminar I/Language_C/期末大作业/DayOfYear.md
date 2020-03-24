# 判断某日是一年中的第几天



---

## 问题分析

按照一定格式输入年月日 输出该日是该年得第几天



闰年判断：四年一闰 百年一闰 四百年再闰

闰年的2月份天数判断

## 代码实现

```c
// Created by SonderLau
#include <stdio.h>

void main()
{
    int day, month, year, sum, leap;
    printf("\nPlease Input a day like YYYY M D\n");
    scanf("%d %d %d", &year, &month, &day); 
    if (month > 12 || month < 1 || day <28 || day >31 || year < 0){
       printf("请输入正确的年份");
    }
    switch (month) 
    {
        case 1:sum = 0;
            break;
        case 2:sum = 31;
            break;
        case 3:sum = 59;
            break;
        case 4:sum = 90;
            break;
        case 5:sum = 120;
            break;
        case 6:sum = 151;
            break;
        case 7:sum = 181;
            break;
        case 8:sum = 212;
            break;
        case 9:sum = 243;
            break;
        case 10:sum = 273;
            break;
        case 11:sum = 304;
            break;
        case 12:sum = 334;
            break;
        default:printf("data error");
            break;
    }
    sum += day;

    // LeapYear
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        leap = 1;
    } else {
        leap = 0;
    }
    if (leap == 1 && month > 2) { 
        sum++;
    }
    printf("This is the %d day of  %d", sum,year);
    
}

```



## 操作说明

输入日期 按照`年 月 日`的格式 之间使用空格区分