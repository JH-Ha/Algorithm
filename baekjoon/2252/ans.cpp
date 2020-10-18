#include <iostream>
#include <vector>
#include <queue>

using namespace std;
class node
{
public:
    int id;
    vector<int> child;
    node()
    {
    }
};
node nodeArr[32010];
int cnt[32010];
int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i <= n; i++)
    {
        nodeArr[i].id = i;
        cnt[i] = 0;
    }
    for (int i = 0; i < m; i++)
    {
        int l, r;
        cin >> l >> r;
        //cout << l << " " << r << endl;
        cnt[r]++;
        nodeArr[l].child.push_back(r);
    }
    // for (int i = 1; i <= n; i++)
    // {
    //     cout << i << " " << nodeArr[i].cnt << endl;
    // }
    queue<node> q;
    for (int i = 1; i <= n; i++)
    {
        if (cnt[i] == 0)
        {
            q.push(nodeArr[i]);
        }
    }
    vector<int> ans;
    while (!q.empty())
    {
        node front = q.front();
        q.pop();
        ans.push_back(front.id);
        //cout << "front id " << front.id << endl;
        for (int i = 0; i < front.child.size(); i++)
        {
            cnt[front.child[i]]--;
            //  cout << "front child " << front.child[i].id << " " << front.child[i].cnt << endl;
            if (cnt[front.child[i]] == 0)
            {
                q.push(nodeArr[front.child[i]]);
            }
        }
    }
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
    cout << '\n';
    return 0;
}