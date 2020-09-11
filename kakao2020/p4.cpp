#include <string>
#include <vector>
#include <iostream>

using namespace std;

struct Trie
{
    bool finish;
    Trie *node[26];
    Trie()
    {
        finish = false;
        for (int i = 0; i < 26; i++)
        {
            node[i] = NULL;
        }
    }
    void insert(const char *str)
    {
        if (*str == '\0')
        {
            finish = true;
            return;
        }
        int cur = *str - 'a';
        if (node[cur] == NULL)
        {
            node[cur] = new Trie();
        }
        node[cur]->insert(str + 1);
    }

    int find(const char *str)
    {
        if (*str == '\0')
        {
            if (finish)
                return 1;
            else
                return 0;
        }
        int ans = 0;
        if (*str == '?')
        {
            for (int i = 0; i < 26; i++)
            {
                if (node[i] != NULL)
                {
                    ans += node[i]->find(str + 1);
                }
            }
            return ans;
        }

        int cur = *str - 'a';
        if (node[cur] == NULL)
        {
            return 0;
        }
        else
        {
            return node[cur]->find(str + 1);
        }
    }
};

string reverse(string s)
{
    for (int i = 0; i < s.size() / 2; i++)
    {
        char temp = s[i];
        s[i] = s[s.size() - 1 - i];
        s[s.size() - 1 - i] = temp;
    }
    return s;
}

vector<int> solution(vector<string> words, vector<string> queries)
{
    Trie *root = new Trie();
    Trie *reverseRoot = new Trie();
    for (int i = 0; i < words.size(); i++)
    {
        root->insert(words[i].c_str());
        reverseRoot->insert(reverse(words[i]).c_str());
    }
    vector<int> answer;
    for (int i = 0; i < queries.size(); i++)
    {
        if (queries[i][0] == '?')
        {
            answer.push_back(reverseRoot->find(reverse(queries[i]).c_str()));
        }
        else
        {
            answer.push_back(root->find(queries[i].c_str()));
        }
    }

    return answer;
}

int main()
{
    int n, q;
    cin >> n >> q;
    vector<string> words;
    string input;
    for (int i = 0; i < n; i++)
    {
        cin >> input;
        words.push_back(input);
    }
    vector<string> queries;
    for (int i = 0; i < q; i++)
    {
        cin >> input;
        queries.push_back(input);
    }
    vector<int> answer = solution(words, queries);
    for (int i = 0; i < answer.size(); i++)
    {
        cout << answer[i] << '\n';
    }
}