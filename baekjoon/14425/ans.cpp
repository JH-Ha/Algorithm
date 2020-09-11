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
    void insert(char *str)
    {
        if (*str == '\0')
        {
            finish = true;
            return;
        }

        int cur = *str - 'a';
        if (node[cur] == NULL)
            node[cur] = new Trie();
        node[cur]->insert(str + 1);
    }
    bool find(char *str)
    {
        if (*str == '\0')
        {
            if (finish == true)
                return true;
            else
                return false;
        }
        int cur = *str - 'a';
        if (node[cur] == NULL)
            return false;
        else
            return node[cur]->find(str + 1);
    }
};

int main()
{
    int n, m;
    cin >> n >> m;
    Trie *root = new Trie();
    for (int i = 0; i < n; i++)
    {
        char input[510];
        cin >> input;
        root->insert(input);
    }
    int num = 0;
    for (int i = 0; i < m; i++)
    {
        char input[510];
        cin >> input;
        if (root->find(input))
            num++;
    }
    cout << num << '\n';

    return 0;
}