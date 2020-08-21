#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char **argv)
{
    int t;
    cin >> t;
    for (int testIdx = 1; testIdx <= t; testIdx++)
    {
        int n, k;
        cin >> n >> k;

        vector<int> a;
        vector<int> b;
        for (int i = 0; i < n; i++)
        {
            int inputA;
            cin >> inputA;
            a.push_back(inputA);
        }
        for (int i = 0; i < n; i++)
        {
            int inputB;
            cin >> inputB;
            b.push_back(inputB);
        }
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        int max = 0;
        for (int i = 0; i < k; i++)
        {
            int sum = a[i] + b[k - i - 1];
            if (sum > max)
                max = sum;
        }
        cout << "Case #" << testIdx << endl;
        cout << max << endl;
    }
    return 0;
}