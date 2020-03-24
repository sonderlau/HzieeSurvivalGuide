// Created by Albrich
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