// Created by LinBaiYin
#include<stdio.h>
#include<stdlib.h>
#include <time.h>
int main() {
	int a;
	for (;;) {
		srand((unsigned)time(NULL));
		a = rand() % 101;
		int b=-1,sum=0;
		while (b != a) {
			scanf("%d", &b);
			if (b == a) {
				sum++;
				printf("你用了%d次猜中了\n",sum);
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
