#include<iostream>
#include<algorithm>

using namespace std;
int n;
int a[1010];
int dp[1010];

int main(){
    cin >> n;
    for(int i = 0; i < n; i ++){
        cin >> a[i];
    }
    dp[0] = 1;
    int ans = dp[0];
    for(int i = 1; i < n ; i ++){
        int localMax = 0;
        for(int j = 0; j < i; j ++){
            if(a[i] > a[j]){
                localMax = max(localMax, dp[j]);
            }
        }
        dp[i] = localMax + 1;
        ans = max(ans, dp[i]);
    }
    cout << ans << '\n';

    return 0;
}