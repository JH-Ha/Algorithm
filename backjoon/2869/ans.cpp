#include<iostream>

using namespace std;

int main(){
    int a, b, v;
    cin >> a >> b >> v;
    
    int result = (v - a) / (a - b) + 1;
    if((v - a) % (a - b) > 0) result ++;
    
    cout << result << endl;;
    return 0;
}