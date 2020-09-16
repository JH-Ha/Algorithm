#include <iostream>

using namespace std;

int heapNum = 0;

int heap[1000010];

void insertHeap(int n)
{
    heap[heapNum] = n;

    int cur = heapNum;
    int parent = (cur - 1) / 2;
    heapNum++;
    while (parent >= 0)
    {
        if (heap[parent] > heap[cur])
        {
            int temp = heap[cur];
            heap[cur] = heap[parent];
            heap[parent] = temp;
            cur = parent;
            parent = (cur - 1) / 2;
            if (cur == 0)
            {
                break;
            }
        }
        else
        {
            break;
        }
    }
}

int popHeap()
{
    if (heapNum == 0)
    {
        return 0;
    }
    int pop = heap[0];
    int last = heap[heapNum - 1];
    heapNum--;
    heap[0] = last;
    int cur = 0;
    while (cur < heapNum)
    {
        int leftChild = cur * 2 + 1;
        int rightChild = cur * 2 + 2;
        if (leftChild < heapNum && rightChild < heapNum)
        {
            if (heap[leftChild] <= heap[rightChild] && heap[leftChild] <= heap[cur])
            {
                int temp = heap[leftChild];
                heap[leftChild] = heap[cur];
                heap[cur] = temp;
                cur = leftChild;
            }
            else if (heap[rightChild] <= heap[leftChild] && heap[rightChild] <= heap[cur])
            {
                int temp = heap[rightChild];
                heap[rightChild] = heap[cur];
                heap[cur] = temp;
                cur = rightChild;
            }
            else
            {
                break;
            }
        }
        else if (leftChild < heapNum && heap[leftChild] < heap[cur])
        {
            int temp = heap[leftChild];
            heap[leftChild] = heap[cur];
            heap[cur] = temp;
            cur = leftChild;
        }
        else
        {
            break;
        }
    }
    return pop;
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        insertHeap(input);
        // for (int i = 0; i < heapNum; i++)
        // {
        //     cout << heap[i] << " ";
        // }
        // cout << endl;
    }

    for (int i = 0; i < n; i++)
    {
        cout << popHeap() << '\n';
        // for (int i = 0; i < heapNum; i++)
        // {
        //     cout << heap[i] << " ";
        // }
        // cout << endl;
    }
    return 0;
}