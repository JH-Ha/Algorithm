#include<iostream>
#include<iomanip>
#include<algorithm>

using namespace std;

int n, m;

int numArr[500010];

int main(){
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    long long n, k;

    cin >> n >> k;
    long long right =  n * n;
    long long left = 1;
    long long result = 0;
    while(left <= right){
        long long mid = (left + right) /2;
        long long num = 0;
        for(int i =1; i<= n; i ++){
            num += min(mid/i, n);
        }
        if(num < k){
            left = mid + 1;
        } else{
            result = mid;
            right = mid -1;
        }
    }
    cout << result << endl;
    return 0;
}