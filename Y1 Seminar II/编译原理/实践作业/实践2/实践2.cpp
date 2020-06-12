#include <iostream>
#include <cstring>
#include <stack>
#include<string>
#include<vector>
#define charNum 26
using namespace std;
vector<string>keywods = { "auto","break","case","char","const","continue","default","do","double",
            "else","enum","extern","float","for","goto","if","int","long","register","return","short",
            "signed","sizeof","static","struct","switch","typedef","union","unsigned","void","volatile","while" };
int judgeString(char tstr);


class TrieNode
{
public:
    char data;
    TrieNode* children[charNum];
    size_t count;
    bool isEndOfWord;
    size_t freq;    
    TrieNode(char ch = '/') :data(ch), isEndOfWord(false), count(0), freq(0)
    {
        memset(children, 0, sizeof(TrieNode*) * charNum);
    }
    ~TrieNode() {}
};
class Trie
{
public:
    TrieNode* root;
    Trie()
    {
        root = new TrieNode;
    }
    ~Trie()
    {
        destory(root);
    }
    void insert(const string& text)
    {
        TrieNode* p = find_private(text);
        if (p)
        {
            p->freq++;
            return;
        }
        p = root;
        int index;
        for (int i = 0; i < text.size(); ++i)
        {
            index = text[i] - 'a';
            if (p->children[index] == NULL)
            {
                TrieNode* newNode = new TrieNode(text[i]);
                p->children[index] = newNode;
            }
            p->count++;
            p = p->children[index];
        }
        p->count++;

    }
    bool find(const string& text) const
    {
        TrieNode* p = root;
        TrieNode* p0 = 0;
        int index;
        int flag = 0;
        for (int i = 0; i < text.size(); ++i)
        {
            char c = text[i];

            index = text[i] - 'a';
            if (p->children[index] == NULL)//还没匹配完
            {

                return 0; 
            }

            p = p->children[index];
        }
        if (p->isEndOfWord == false)
        {

            return 0;
        }
        else
        {

            return 1;
        }
    }

private:
    TrieNode* find_private(const string& text) const
    {
        TrieNode* p = root;
        int index;
        for (int i = 0; i < text.size(); ++i)
        {
            index = text[i] - 'a';
            if (p->children[index] == NULL)
                return NULL;//还没匹配完
            p = p->children[index];
           // cout << "1" << endl;
        }
        if (p->isEndOfWord == false)
            return NULL;
        else
        {
            return p;
        }
    }

public:
    void destory(TrieNode* proot)
    {
        if (proot == NULL)
        {
            return;
        }
        for (int i = 0; i < charNum; ++i)
        {
            destory(proot->children[i]);
        }
        delete proot;
        proot = NULL;
    }
    bool delString(const string& text)
    {
        TrieNode* p = root;
        stack<TrieNode*> nodeStack;
        nodeStack.push(root);
        int index;
        for (int i = 0; i < text.size(); ++i)
        {
            index = text[i] - 'a';
            if (p->children[index] == NULL)
                return false;//还没匹配完
            p = p->children[index];
            nodeStack.push(p);
        }
  
        if (p->isEndOfWord == false)
            return false;
        else
        {
            while (nodeStack.top()->count == 1)
            {
                index = nodeStack.top()->data - 'a';
                delete nodeStack.top();
                nodeStack.pop();
            }
            nodeStack.top()->children[index] = NULL;
            while (!nodeStack.empty())
            {
                nodeStack.top()->count--;
                nodeStack.pop();
            }
            return true;
        }
    }
    size_t itemCount() const
    {
        return root->count;
    }
   

};
int identifyString(char tstr)
{
    if (tstr == ',' || tstr == ';' || tstr == '(' || tstr == ')' ||
        tstr == '{' || tstr == '}' || tstr == '[' || tstr == ']' ||
        tstr == '\"' || tstr == '\'' || tstr == '<' || tstr == '>')
    {
        cout << endl << "//" << tstr << " is delimite" << endl; 
        return 1;
    }
    return 0;
}

int judgeHead(string tstr)
{
    if (tstr[0] == '#')
    {
        //if (tstr.substr(1, 8) == "include<")
        {
            int flag = 0;
            for (int i = 0; i < tstr.size(); i++)
            {
                char c = tstr[i];
                if (c == '<') { flag = i; break; }
            }
            cout << endl << "//" << tstr.substr(flag+1,tstr.size()-flag-2) << " is headfile"<<endl;
            return 1;
        }
    }
    return 0;
}

int identifyKey(string tstr)
{
    
    for (vector<string>::iterator it = keywods.begin(); it < keywods.end(); it++)
    {
        if (tstr == *it)
        {
            cout << endl << "//" << *it << " is keywords." << endl; return 1;
        }
        return 0;
    }
}
int identifyStr(string tstr)
{
    int flag = 0;
    for (int i = 0; i < tstr.size(); i++)
    {
       char c = tstr[i];
       if (!isalpha(c) || !(c != '_')) { if (judgeString(c)) { if (i > 0)cout << endl << "//" << tstr.substr(flag, i-flag) << "　is inversed word." << endl;  flag = i+1; } }
    }
    if(flag!=tstr.size())cout << endl << "//" << tstr.substr(flag, tstr.size()) << " is inversed word." << endl;
    return 0;
}
    

int main()
{
    Trie Textlib;
    Textlib.insert("ialwaysloveu");
    string tstr;
    while (cin >> tstr)
    {
        char c = tstr[0];
        if (identifyString(c))continue;
        if (identifyHead(tstr))continue;
        if (identifyKey(tstr))continue;
        else { 
            identifyStr(tstr);

        }
    
     }

	return 0;
}