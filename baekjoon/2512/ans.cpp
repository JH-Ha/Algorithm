#include<iostream>

using namespace std;

long long budget[10010];

int main(){
    int n;
    cin >> n;
    long long bMax = 0;
    for (int i = 0; i < n; i ++){
        cin >> budget[i];
        bMax = max(budget[i], bMax);
    }
    long long max;
    long long a = 0, b = bMax;

    cin >> max;
    long long result = 0;
    while(a <= b){
        long long mid = (a+b)/2;
        long long sum = 0;
        for(int i = 0; i < n; i ++){
            sum += min(budget[i], mid);
        }
        if(sum > max){
            b = mid - 1;
        } else{
            result = mid;
            a = mid + 1;
        }
    }
    cout << result << endl;
    
    return 0;
}