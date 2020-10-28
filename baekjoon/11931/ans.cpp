#include <iostream>
#include <vector>

using namespace std;
int ans[1000010];
int input[1000010];

void merge(int left, int right)
{
    int mid = (left + right) / 2;
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right)
    {
        if (input[i] < input[j])
        {
            ans[k++] = input[j++];
        }
        else
        {
            ans[k++] = input[i++];
        }
    }
    while (i <= mid)
    {
        ans[k++] = input[i++];
    }
    while (j <= right)
    {
        ans[k++] = input[j++];
    }
    for (int i = left; i <= right; i++)
    {
        input[i] = ans[i];
    }
}

void partition(int left, int right)
{
    if (left < right)
    {
        int mid = (left + right) / 2;
        partition(left, mid);
        partition(mid + 1, right);
        merge(left, right);
    }
}

int main()
{

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> input[i];
    }
    partition(0, n - 1);
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", input[i]);
    }
}