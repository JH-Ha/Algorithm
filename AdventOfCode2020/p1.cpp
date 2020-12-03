#include <iostream>

using namespace std;

int main()
{
    int n = 200;
    int arr[200];
    for (int i = 0; i < 200; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < 200; i++)
    {
        for (int j = i + 1; j < 200; j++)
        {
            for (int k = j + 1; k < 200; k++)
            {
                if (arr[i] + arr[j] + arr[k] == 2020)
                {
                    cout << "arr[" << i << "]: " << arr[i] << " arr[" << j << "]: " << arr[j] << " arr[" << k << "]:" << arr[k] << endl;
                    cout << arr[i] * arr[j] * arr[k] << endl;
                }
            }
        }
    }

    return 0;
}