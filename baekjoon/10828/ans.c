#include <stdio.h>

struct stack
{
    int topIdx;
    int items[10010];
};

struct stack myStack;

void push(int x)
{
    myStack.topIdx++;
    myStack.items[myStack.topIdx] = x;
}
int pop()
{
    if (myStack.topIdx == -1)
    {
        return -1;
    }
    else
    {
        return myStack.items[myStack.topIdx--];
    }
}

int size()
{
    return myStack.topIdx + 1;
}
int empty()
{
    return myStack.topIdx < 0 ? 1 : 0;
}
int top()
{
    return myStack.items[myStack.topIdx];
}

int main()
{
    int n;
    scanf("%d", &n);
    myStack.topIdx = -1;
    for (int i = 0; i < n; i++)
    {
        char input[100];
        scanf("%s", input);
        if (input[0] == 'p' && input[1] == 'u')
        {
            char inputNum[100];
            scanf("%s", inputNum);
            int idx = 0;
            int num = 0;
            while (inputNum[idx] != '\0')
            {
                num *= 10;
                num += (inputNum[idx] - '0');
                idx++;
            }
            //printf("push %d\n", num);
            push(num);
        }
        else if (input[0] == 't')
        {
            printf("%d\n", top());
        }
        else if (input[0] == 'e')
        {
            printf("%d\n", empty());
        }
        else if (input[0] == 'p' && input[1] == 'o')
        {
            printf("%d\n", pop());
        }
        else if (input[0] == 's')
        {
            printf("%d\n", size());
        }
    }
}