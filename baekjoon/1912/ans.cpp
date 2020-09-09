#include<iostream>
#include<algorithm>

using namespace std;

long long a[100010];
int n;

int main(){
    cin >> n;
    for(int i = 0; i < n; i ++){
        cin >> a[i];
    }
    long long ans = -1001;
    long long subSum = -1001;
    for(int i = 0; i < n; i ++){
        subSum = max(subSum + a[i], a[i]);
        ans = max(subSum, ans);
    }
    cout << ans << '\n';
    return 0;
}