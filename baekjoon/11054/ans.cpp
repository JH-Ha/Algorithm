#include<iostream>
#include<algorithm>

using namespace std;
int n;
int a[1010];
int incresing[1010];
int decresing[1010];
int main(){
    cin >> n;
    for(int i = 0; i < n; i ++){
        cin >> a[i];
    }
    incresing[0] = 1;
    decresing[n-1] = 1;
    for(int i = 1; i < n; i ++){
        incresing[i] = 0;
        for(int j = 0; j < i ; j ++){
            if(a[i] > a[j]){
                incresing[i] = max(incresing[i], incresing[j]);
            }
        }
        incresing[i] ++ ;
    }
    for(int i = n -2; i >= 0; i --){
        decresing[i] = 0;
        for(int j = n-1; j >i; j --){
            if(a[i] > a[j]){
                decresing[i] = max(decresing[i], decresing[j]);
            }
        }
        decresing[i] ++ ;
    }
    // for(int i = 0; i < n; i ++){
    //     cout << decresing[i] << " ";
    // }
    // cout << '\n';
    int ans = 0;
    for(int i = 0; i < n; i ++){
        ans = max(incresing[i] + decresing[i], ans);
    }
    ans --;
    cout << ans << '\n';

    return 0;
}