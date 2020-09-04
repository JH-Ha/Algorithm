#include<stdio.h>

int num[10001];
int coin[101];
int main(){
    int n, k;
    scanf("%d %d",&n,&k);
    for(int i = 1; i <= n ; i ++){
        scanf("%d", &coin[i]);
    }
    for(int i = 0; i <= k; i ++){
        num[i] = 0;
    }
    num[0] = 1;
    for(int i = 1 ; i <= n; i ++){
        for(int j = 0; j <= k; j ++){
            if(j - coin[i] >= 0)
                num[j] = num[j - coin[i]] + num[j];            
        }
    }
    printf("%d\n",num[k]);
    return 0;
}