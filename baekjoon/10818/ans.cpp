#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int min = 1000010;
    int max = -1;
    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        if (max < input)
        {
            max = input;
        }
        if (min > input)
        {
            min = input;
        }
    }
    printf("%d %d\n", min, max);
    return 0;
}