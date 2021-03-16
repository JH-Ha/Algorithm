#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

struct cmp
{
    bool operator()(int a, int b)
    {
        return a > b;
    }
};
int arr[2250010];
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;

    // 1. 정렬 풀이
    // for (int i = 0; i < n * n; i++)
    // {
    //     cin >> arr[i];
    // }
    // sort(arr, arr + n * n);
    // cout << arr[n * n - n] << endl;

    // 2. priority queue 풀이
    priority_queue<int, vector<int>, cmp> pq;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int input;
            cin >> input;
            pq.push(input);
        }
        while (pq.size() > n)
        {
            pq.pop();
        }
    }
    cout << pq.top() << endl;
    return 0;
}