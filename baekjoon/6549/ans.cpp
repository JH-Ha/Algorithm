#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void init(vector<int> &h, vector<int> &tree, int node, int start, int end)
{
    if (start == end)
    {
        tree[node] = start;
    }
    else
    {
        init(h, tree, node * 2, start, (start + end) / 2);
        init(h, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        if (h[tree[node * 2]] <= h[tree[node * 2 + 1]])
        {
            tree[node] = tree[node * 2];
        }
        else
        {
            tree[node] = tree[node * 2 + 1];
        }
    }
}

int query(vector<int> &h, vector<int> &tree, int node, int start, int end, int i, int j)
{
    if (i > end || j < start)
    {
        return -1;
    }
    if (i <= start && end <= j)
    {
        return tree[node];
    }
    int m1 = query(h, tree, node * 2, start, (start + end) / 2, i, j);
    int m2 = query(h, tree, node * 2 + 1, (start + end) / 2 + 1, end, i, j);

    if (m1 == -1)
    {
        return m2;
    }
    else if (m2 == -1)
    {
        return m1;
    }
    else if (h[m1] < h[m2])
    {
        return m1;
    }
    else
    {
        return m2;
    }
}

long long find(vector<int> &h, vector<int> &tree, int i, int j)
{
    int n = h.size();
    int m = query(h, tree, 1, 0, n - 1, i, j);
    long long area = (long long)(j - i + 1) * (long long)h[m];
    if (i <= m - 1)
    {
        long long leftArea = find(h, tree, i, m - 1);
        area = max(area, leftArea);
    }
    if (j >= m + 1)
    {
        long long rightArea = find(h, tree, m + 1, j);
        area = max(area, rightArea);
    }
    return area;
}
int main()
{
    int n;
    cin >> n;
    while (n != 0)
    {
        vector<int> h(n);
        for (int i = 0; i < n; i++)
        {
            cin >> h[i];
        }
        int treeH = (int)(ceil(log2(n)));
        int treeSize = (1 << (treeH + 1));
        vector<int> tree(treeSize);
        init(h, tree, 1, 0, n - 1);
        cout << find(h, tree, 0, n - 1) << endl;
        cin >> n;
    }

    return 0;
}