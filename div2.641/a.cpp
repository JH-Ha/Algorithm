#include<iostream>

using namespace std;
int minDiv[1000010];

int main(){
    int t;
    cin >> t;
    for(int i = 0; i < 1000010; i ++){
        minDiv[i] = i;
    }
    for(int i = 2; i * i < 1000010; i ++){
        if(minDiv[i] == i){
            for(int j = i * i; j < 1000010; j += i){
                if(minDiv[j] == j) minDiv[j] = i;
            }
        }
    }
    // for(int i = 0; i < 20; i ++){
    //     cout << i << " "<<minDiv[i] << endl;
    // }
    while (t --){
        int n,k;
        cin >> n>> k;
        //for(int i = 0; i < k; i ++){
        n = n + minDiv[n] + (k-1) * 2;
        //}
        cout << n << endl;
    }
    return 0;
}