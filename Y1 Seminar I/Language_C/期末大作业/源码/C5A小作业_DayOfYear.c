// Created by SonderLau
#include <stdio.h>

void main()
{
    int day, month, year, sum, leap;
    printf("\nPlease Input a day like YYYY M D\n");
    scanf("%d %d %d", &year, &month, &day);
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
