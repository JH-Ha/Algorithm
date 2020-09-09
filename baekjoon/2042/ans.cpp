#include<iostream>

using namespace std;

long long tree[4000010];

void update(int idx, int value){
    long long minus = tree[idx];
    int p = idx;
    while(p != 0){
        tree[p] = tree[p] - minus + value;
        p = p/2;
    }
}
long long sum(int b, int c){
    long long resultSum = 0;
    while(b<c){
        //check b is odd
        if((b & 1) == 1){
            resultSum += tree[b];
            b ++;
        }
        if((c& 1) == 0){
            resultSum += tree[c];
            c --;
        }
        b = b/2;
        c = c/2;
    }
    if(b == c){
        resultSum += tree[b];
    }
    return resultSum;
}

int main(){
    int n, m, k;
    cin >> n >> m >> k;
    int s = 1;
    while(s < n){
        s = s<<1;
    }
    //initialize
    for(int i = 0; i < s; i ++){
        tree[i] = 0;
    }
    for(int i = s; i < s+  n; i ++){
        cin >> tree[i];
    }
    for(int i = s; i < s+ n; i ++){
        int p = i/2;
        while(p != 0){
            tree[p] = tree[p] + tree[i];
            p = p/2;
        }
    }
    for(int i = 1; i <= m + k ; i ++){
        int a, b, c;
        cin >> a >> b >> c;
        if(a == 1){
            update(s + b - 1, c);
        }else{
            cout << sum(s + b - 1, s + c - 1) << endl;
        }
    }
    return 0;
}