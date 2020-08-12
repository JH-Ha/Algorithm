#include <iostream>
#include <utility>
using namespace std;

int numFiboCall[45][2];

pair<int, int> fibo(int n)
{
    if (n == 0)
        return make_pair(1, 0);
    else if (n == 1)
        return make_pair(0, 1);
    else if (numFiboCall[n][0] == -1)
    {
        numFiboCall[n][0] = fibo(n - 1).first + fibo(n - 2).first;
        numFiboCall[n][1] = fibo(n - 1).second + fibo(n - 2).second;
        return make_pair(numFiboCall[n][0], numFiboCall[n][1]);
    }
    else
    {
        return make_pair(numFiboCall[n][0], numFiboCall[n][1]);
    }
}

int main()
{

    //initialize
    for (int i = 0; i < 45; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            numFiboCall[i][j] = -1;
        }
    }
    numFiboCall[0][0] = 1;
    numFiboCall[0][1] = 0;

    numFiboCall[1][0] = 0;
    numFiboCall[1][1] = 1;

    fibo(44);

    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        cout << numFiboCall[n][0] << " " << numFiboCall[n][1] << endl;
    }
    return 0;
}