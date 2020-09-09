#include<iostream>

using namespace std;

long long power(int a, int b, int c){
    if(b == 1){
        return a % c;
    } else if(b == 0){
        return 1 % c;
    }
    long long ans;
    if(b % 2 == 0){
        ans = power(a,b/2, c) % c;
        ans = ((ans % c) * (ans % c) ) %c;
    } else{
        ans = ((a%c) * (power(a, b-1, c) ))%c;
        //ans = ((ans%c) * (ans%c) * a) %c;
    }
    return ans;
}

int main(){
    long long a,b ,c;
    cin >> a >> b >> c;
    long long ans = power(a,b,c);
    cout << ans << '\n';
    return 0;
}