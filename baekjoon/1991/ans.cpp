#include <iostream>
#include <vector>

using namespace std;
char node[26][2];

void preOrder(int idx)
{
    char left = node[idx][0];
    char right = node[idx][1];
    printf("%c", idx + 'A');
    if (left != '.')
    {
        preOrder(left - 'A');
    }
    if (right != '.')
    {
        preOrder(right - 'A');
    }
}

void inOrder(int idx)
{
    char left = node[idx][0];
    char right = node[idx][1];
    if (left != '.')
    {
        inOrder(left - 'A');
    }
    printf("%c", idx + 'A');
    if (right != '.')
    {
        inOrder(right - 'A');
    }
}

void postOrder(int idx)
{
    char left = node[idx][0];
    char right = node[idx][1];
    if (left != '.')
    {
        postOrder(left - 'A');
    }
    if (right != '.')
    {
        postOrder(right - 'A');
    }
    printf("%c", idx + 'A');
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        char p, c1, c2;
        cin >> p >> c1 >> c2;
        node[p - 'A'][0] = c1;
        node[p - 'A'][1] = c2;
    }
    preOrder(0);
    printf("\n");
    inOrder(0);
    printf("\n");
    postOrder(0);
    printf("\n");
    return 0;
}