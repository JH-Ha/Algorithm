#include <iostream>

using namespace std;
int n,a[100005],dp[100005];
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        cin >> n;
        for(int i = 1; i <= n ; i ++){
            cin >> a[i];
            dp[i] = 1;
        }
        int ans = 1;
        for(int i = n/2 ; i>=1; i --){
            for(int j = 2 * i; j <= n; j += i){
                if(a[i] < a[j]){
                    dp[i] = max(dp[i], dp[j] + 1);
                    ans = max(ans, dp[i]);
                }
            }
        }
        cout << ans << endl;

        
    }
    return 0;
}
