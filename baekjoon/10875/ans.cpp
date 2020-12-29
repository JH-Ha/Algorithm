#include <iostream>
#include <unordered_set>

using namespace std;

int main()
{
    int L;
    cin >> L;
    int N;
    cin >> N;

    unordered_set<long> board;

    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, -1, 0, 1};
    board.insert(0);

    int pos = 0;
    int curX = 0;
    int curY = 0;
    int servived = 0;
    for (int i = 0; i < N; i++)
    {
        int t;
        char turn;
        cin >> t >> turn;
        for (int j = 0; j < t; j++)
        {
            int nextX = curX + dx[pos];
            int nextY = curY + dy[pos];
            //check going outside of the board
            if (nextX >= L || nextX <= -L || nextY >= L || nextY <= -L)
            {
                break;
            }
            //check next point already visited or not
            long key = nextX * L + nextY;
            unordered_set<long>::const_iterator got = board.find(key);
            if (got == board.end())
            {
                board.insert(key);
                curX = nextX;
                curY = nextY;
                servived++;
            }
            else
            {
                break;
            }
        }
        if (turn == 'L')
        {
            pos--;
            if (pos < 0)
                pos += 4;
        }
        else if (turn == 'R')
        {
            pos++;
            pos %= 4;
        }
    }
    cout << servived << endl;
    return 0;
}