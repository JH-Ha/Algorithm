#include <iostream>

using namespace std;

int house[1010][3];

int minCost[1010][3];

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            int cost;
            cin >> cost;
            house[i][j] = cost;
        }
    }
    minCost[0][0] = house[0][0];
    minCost[0][1] = house[0][1];
    minCost[0][2] = house[0][2];

    for (int i = 1; i < n; i++)
    {
        minCost[i][0] = house[i][0] + min(minCost[i - 1][1], minCost[i - 1][2]);
        minCost[i][1] = house[i][1] + min(minCost[i - 1][0], minCost[i - 1][2]);
        minCost[i][2] = house[i][2] + min(minCost[i - 1][0], minCost[i - 1][1]);
    }
    cout << min(min(minCost[n - 1][0], minCost[n - 1][1]), minCost[n - 1][2]) << endl;
    return 0;
}