/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

#include <iostream>

using namespace std;

int Answer;

int a[3010], aSum[3010];
int b[3010], bSum[3010];
//승패 정보를 저장합.
// 1 : win , 0 : lose, -1 : inital value
int game[3010][3010];
int n, k;

int find(int i, int j)
{
    if (game[i][j] == -1)
    {
        bool isWin = false;
        for (int x = i - 1; x >= 0; x--)
        {
            if (aSum[i] - aSum[x] <= k)
            {
                if (find(x, j) == 0)
                    isWin = true;
            }
            else
            {
                break;
            }
        }
        for (int y = j - 1; y >= 0; y--)
        {
            if (bSum[j] - bSum[y] <= k)
            {
                if (find(i, y) == 0)
                    isWin = true;
            }
            else
            {
                break;
            }
        }

        if (isWin)
        {
            game[i][j] = 1;
        }
        else
        {
            game[i][j] = 0;
        }
    }
    return game[i][j];
}

int main(int argc, char **argv)
{
    int T, test_case;
    /*
	   The freopen function below opens input.txt file in read only mode, and afterward,
	   the program will read from input.txt file instead of standard(keyboard) input.
	   To test your program, you may save input data in input.txt file,
	   and use freopen function to read from the file when using cin function.
	   You may remove the comment symbols(//) in the below statement and use it.
	   Use #include<cstdio> or #include <stdio.h> to use the function in your program.
	   But before submission, you must remove the freopen function or rewrite comment symbols(//).
	 */

    // freopen("input.txt", "r", stdin);

    cin >> T;
    for (test_case = 0; test_case < T; test_case++)
    {

        Answer = 0;

        cin >> n >> k;
        //초기화
        for (int i = 0; i < 3010; i++)
        {
            for (int j = 0; j < 3010; j++)
            {
                game[i][j] = -1;
            }
        }
        int input;
        aSum[0] = bSum[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            cin >> input;
            a[i] = input;
            aSum[i] = aSum[i - 1] + a[i];
        }
        for (int i = 1; i <= n; i++)
        {
            cin >> input;
            b[i] = input;
            bSum[i] = bSum[i - 1] + b[i];
        }
        game[0][0] = 1;
        game[1][0] = 0;
        game[0][1] = 0;

        find(n, n);
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (game[i][j] == 1)
                {

                    Answer++;
                }
                // else
                // {
                //     cout << "lose game[" << i << "][" << j << "]" << endl;
                // }
            }
        }
        // for (int i = 0; i <= n; i++)
        // {
        //     for (int j = 0; j <= n; j++)
        //     {
        //         cout << game[i][j] << " ";
        //     }
        //     cout << endl;
        // }
        // Print the answer to standard output(screen).
        cout << "Case #" << test_case + 1 << endl;
        cout << Answer << " " << (n + 1) * (n + 1) - Answer << endl;
    }

    return 0; //Your program should return 0 on normal termination.
}