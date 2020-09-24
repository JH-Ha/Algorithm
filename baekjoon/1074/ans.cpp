#include <iostream>

using namespace std;

int maxWidth = 2;
int N, r, c;

int answer = 0;

void find(int width, int is, int js)
{
    if (width == 0)
    {
        return;
    }
    if (is <= r && r < is + width)
    {
        if (js <= c && c < js + width)
        {
            find(width / 2, is, js);
        }
        else
        {
            answer += width * width;
            find(width / 2, is, js + width);
        }
    }
    else
    {
        if (js <= c && c < js + width)
        {
            answer += width * width * 2;
            find(width / 2, is + width, js);
        }
        else
        {
            answer += width * width * 3;
            find(width / 2, is + width, js + width);
        }
    }
}

int main()
{

    cin >> N >> r >> c;

    for (int i = 0; i < N; i++)
    {
        maxWidth *= 2;
    }
    find(maxWidth / 2, 0, 0);
    cout << answer << '\n';
    return 0;
}