#include<iostream>
#include<vector>
#include<algorithm>
#include<stack>
#include<string>
#include<map>
using namespace std;

int tans = 0;
int tkk = 0;
int process(string tstr);
int process(int num, string tstr, int number);

int judgeKey(string tstr)
{

    //for (vector<string>::iterator it = keywods.begin(); it < keywods.end(); it++)

    if (tstr == "if")
        return 1;

    return 0;
    //}
}

int scan(string tstr, int tk)
{
    int flag = 0;
    for (int i = tk; i < tstr.size(); i++)
    {
        if (isalpha(tstr[i]))continue;
        flag = i; break;
    }
    return flag;
}
int calc(string tstr)
{
    int ans = 0;//for return the answer
    int cnt = 0;//used for record the digit that iterated
    int flag = 0;//used for record the site of =
    int ttans = 0;
    int tcnt = 0;
    for (int i = 0; i < tstr.size(); i++)
    {
        if (tstr[i] == '=') {
            flag = i; break;
        }
    }

    for (int i = flag; i < tstr.size(); i++)
    {
        if (tstr[i] == '(') { tans = 0; i += process(tstr.substr(i + 1)); cnt += tans; continue; }
        if (isdigit(tstr[i])) { cnt = cnt * 10 + (int)(tstr[i] - '0'); }
        if (tstr[i] == '+') { ans += tcnt; tcnt = 0; ans += process(0, tstr.substr(i + 1), cnt); cnt = 0; }
        if (tstr[i] == '-') { ans += tcnt; tcnt = 0; ans += process(1, tstr.substr(i + 1), cnt); cnt = 0; }
        if (tstr[i] == '*') {

            if (tcnt != 0) tcnt *= process(2, tstr.substr(i + 1), cnt); else tcnt = process(2, tstr.substr(i + 1), cnt);
            ; cnt = 0;
        }
        if (tstr[i] == '/') {
            if (cnt == 0) { cnt = tcnt; tcnt = 0; }
            if (tcnt != 0) tcnt /= process(3, tstr.substr(i + 1), cnt); else tcnt = process(3, tstr.substr(i + 1), cnt);
            cnt = 0;
        }

        if (cnt == 0) { i += tkk; tkk = 0; }
        if (i == tstr.size() - 1)ans += tcnt;
        //cout << ans << endl;
    }
    return ans;
}
int process(int num, string tstr, int number)
{
    int ans = 0;
    for (int i = 0; i < tstr.size(); i++)
    {
        if (tstr[i] == '(') { i += process(tstr.substr(i + 1)); ans = tans; tkk = i + 1; tans = 0;   break; }
        if (!isdigit(tstr[i])) { tkk = i; break; }
        else { ans = ans * 10 + (int)(tstr[i] - '0'); if (i == tstr.size() - 1)tkk = i + 1; }
    }
    // cout << endl <<number<<" "<< ans << endl;
    switch (num)
    {
    case 0:return number + ans; break;
    case 1:return number - ans; break;
    case 2:return number * ans; break;
    case 3:return number / ans; break;
    default:
        break;
    }
}
int process(string tstr)
{
    for (int i = 0; i < tstr.size(); i++)
    {
        if (tstr[i] == ')') { tans = calc(tstr.substr(0, i)); return i; }
    }
}

int main()
{
    string tstr[200];
    int ptr = 0;
    int ff = 1;
    while (cin >> tstr[ptr] && tstr[ptr] != "#")
    {
        ptr++;
    }





    for (int i = 0; i < ptr; i++)
    {
        int flag1 = 0;
        int flag2 = 0;
        if (ff) {
            flag1 = scan(tstr[i], flag1);
            if (judgeKey(tstr[i].substr(0, 2))) {
                if (tstr[i].substr(flag1, 1) != "(")
                {
                    cout << endl << "Error syntax." << endl;
                   // cout << endl << tstr[i] << endl;
                    continue;
                }
                else
                {
                    if (tstr[i].substr(0)[flag1 + 1] == '0') { ff = 0; cout << endl << "The expression is false." << endl; }
                    else { ff = 1; cout << endl << "The expression is true." << endl;
                    }
                    continue;
                }
            }
            if (flag1 != tstr[i].size())
            {
                cout << endl << tstr[i].substr(0, flag1) << "=" << calc(tstr[i].substr(flag1 + 1)) << endl;
                continue;
            }
        }
        else { ff = 1; cout << endl << "The following sentense is failure." << endl; }
    }
    return 0;
}