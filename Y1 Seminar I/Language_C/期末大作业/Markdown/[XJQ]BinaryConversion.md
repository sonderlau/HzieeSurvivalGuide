# Binary Conversation

---

## 问题分析

输入需要转换的进制 输入转换的数

输出其他进制的转换结果



十进制→ 二进制：十进制数除以二，除至0后，所得余数按照反方向写出即可

对不同进制转换采用不同的函数进行处理

其他进制同上

## 代码实现

```cpp
// Created by Albrich
// 			 Written in C
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int TenNum(char a[], int B);              //将输入的数字转换成10进制数
void Numchange(int m, int B);            //将转换好了的10进制数转换为所需进制数
int TenNum(char a[], int B)
{
	int len, i, num;
	int sum = 0;
	len = strlen(a);                    //求得字符串长度
	for (i = 0; i < len; i++)
	{
		if (a[i] >= '0' && a[i] <= '9')
			num = a[i] - '0';
		else if (a[i] >= 'A' && a[i] <= 'F')
			num = a[i] - 'A' + 10;
		sum = sum * B + num;
	}
	return sum;
}
void Numchange(int m, int B)
{
	int n;
	if (m)
	{
		Numchange(m / B, B);
		n = m % B;
		if (n < 10)
			printf("%d", n);           //小于10直接输出
		else
			printf("%c", n + 55);      //大于10转换成字符输出
	}
}
int main()
{
	int B, b;
	char a[20];
	do {
		printf("\n请输入待转换数的进制：");
		scanf_s("%d", &B);
	} while (B < 2 && B > 16);
	printf("\n请输入待转换数：");
	getchar();
	gets_s(a);                        //将输入的n进制数存放在数组a中
	int m = TenNum(a, B);             //将输入的数字转换成十进制数
	//以下为改成任何进制进制的模板
	//printf("请输入需要转成几进制数（2-16）：");
	/*do {
		scanf_s("%d", &b);
	} while (B < 2 && B > 16);
	printf("%d进制数%s转换为%d进制数的结果为：", B, a, b);*/
	printf("\n转换为10进制数的结果为：");
	Numchange(m, 10);
	printf("\n转换为16进制数的结果为：");
	Numchange(m, 16);
	printf("\n转换为2进制数的结果为：");
	Numchange(m, 2);                 //将十进制数转换为所需进制数
	printf("\n");
	system("pause");
	return 0;
}


// ------------------------------------------------------------
// Created by Albrich
// 			Written in C++
#include <iostream>
#include <iomanip>
#include <vector>
#include <string>
#include <cmath>
#include <stack>
#define _for(i,a,b) for(int i=a;i<b;i++)

using namespace std;
void pri(string & n);
void binaryc();
void hexc();
void demical(int x, int jz);
int cg(string n);
void judge(string& n)
{
	int nu = n.length();
	while (nu)
	{
		if (n[nu - 1] > 47 && n[nu - 1] < 58) { nu--; continue; }
		else
		{
			cout << endl << "请输入数字" << endl;
			pri(n);
		}
		nu--;
	}
}
void pri(string& n)
{
	cin >> n;
	judge(n);
}
int hexxxxxx;
char hc[] = { '0','1','2','3','4','5','6','7','8','9',' A','B','C','D','E','F' };
int main()
{
	int  n, n1;
	string sn, sn1;
	while (true)
	{
		system("cls");
		hexxxxxx = 0;
		cout << "请输入想要转换的数的数制： ";
		cin >> sn;
		judge(sn);
		cout << "请输入这个" << sn << "进制数:";
		cin >> sn1;
		judge(sn1);
		/*for (int i = 0; i < sn1.length(); i++)
		{
			cout << endl << (int)sn1[i]-48;
		}*/
		n1 = cg(sn1);
		n = cg(sn);
		demical(n1, n);
		hexc();
		binaryc();
		cout << "退出请输入0,任意其他数字再来一遍" << endl;
		cin >> n;
		if (!n)
			break;
	}
	return 0;
}

void demical(int x, int jz)
{
	int cnt = 0;
	while (x)
	{
		hexxxxxx += pow(jz, cnt++) * (x % 10);
		x /= 10;
	}
	cout << "该数的十进制表示为：" << hexxxxxx << endl;
}

void binaryc()
{
	int temp = hexxxxxx; int tp;
	stack<int> tp1;
	cout << "该数的二进制表示为:";
	while (temp)
	{
		tp = temp % 2 ? 1 : 0;
		tp1.push(tp);
		temp /= 2;
	}
	while (!tp1.empty())
	{
		cout << tp1.top();
		tp1.pop();
	}
	cout << endl;
}

void hexc()
{
	stack<char>tp1;
	int temp = hexxxxxx;
	cout << "该数的十六进制表示为：";
	while (temp)
	{
		tp1.push(hc[temp % 16]);
		temp /= 16;
	}
	while (!tp1.empty())
	{
		cout << tp1.top();
		tp1.pop();
	}
	cout << endl;
}
int cg(string n)
{
	int nu = 0;
	for (int i = 0; i < n.length(); i++)
	{
		nu *= 10;
		nu += (int)n[i] - 48;
	}
	return nu;
}
```



## 操作说明

输入想要转换的进制 按下回车

输入需要转换的数值 回车

即可得到结果