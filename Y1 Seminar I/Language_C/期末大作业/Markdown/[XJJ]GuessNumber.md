# 猜数字

---

## 问题分析

内部随机取得一个数

提示输入某个范围内的数 并与生成的数进行比较 提示是较大或较小 并继续猜

统计出共猜了几次

## 代码实现

```c
// Created by LinBaiYin
#include<stdio.h>
#include<stdlib.h>
#include <time.h>
int main() {
	int a;
	for (;;) {
		srand((unsigned)time(NULL));
		a = rand() % 101;
		int b = -1, sum = 0;
		printf("---------猜数字---------\n");
		printf("---请输入0--100的数字---\n");
		while (b != a) {
			scanf("%d", &b);
			if (b > 100 || b < 0) {
				printf("请输入正确范围内的数字\n")
			}
			if (b == a) {
				sum++;
				printf("你用了%d次猜中了\n", sum);
			}
			else if (b > a) {
				printf("猜大了\n");
				sum++;
			}
			else if (b < a) {
				printf("猜小了\n");
				sum++;
			}
		}

	}
}

```



## 操作说明

输入范围内的数 并按下回车 

根据提示与目前猜测数的大小 再次输入数 并按下回车

直到猜中后 即可看到共用了多少次才猜中