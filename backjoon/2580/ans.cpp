#include <iostream>

using namespace std;

int sudoku[9][9];
int numLeft = 0;

bool checkPossible(int x, int y, int v)
{
    bool possible = true;
    int xIdx = x / 3 * 3;
    int yIdx = y / 3 * 3;

    for (int i = xIdx; i < xIdx + 3; i++)
    {
        for (int j = yIdx; j < yIdx + 3; j++)
        {
            if (sudoku[i][j] == v)
            {
                possible = false;
                return possible;
            }
        }
    }
    for (int i = 0; i < 9; i++)
    {
        if (sudoku[i][y] == v || sudoku[x][i] == v)
        {
            possible = false;
            return possible;
        }
    }
    // for (int j = 0; j < 9; j++)
    // {
    //     if (sudoku[x][j] == v)
    //     {
    //         possible = false;
    //         return possible;
    //     }
    // }
    return possible;
}

void find()
{
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (sudoku[i][j] == 0)
            {
                for (int v = 1; v <= 9; v++)
                {
                    //cout << i << " " << j << " " << v << " " << checkPossible(i, j, v) << endl;
                    if (checkPossible(i, j, v))
                    {

                        sudoku[i][j] = v;
                        numLeft--;
                        find();
                        if (numLeft == 0)
                        {
                            return;
                        }
                        sudoku[i][j] = 0;
                        numLeft++;
                    }
                }
                return;
            }
        }
    }
}

int main()
{
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> sudoku[i][j];
            if (sudoku[i][j] == 0)
                numLeft++;
        }
    }
    //cout << numLeft << endl;
    find();
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cout << sudoku[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}