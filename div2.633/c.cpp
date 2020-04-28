#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int findMax (int diff){
    int maxExp = 0;;
    for(int i = 0; i < 32; i ++){
        if(diff < pow(2,i)){
            maxExp = i;
            break;
        }
    }
    return maxExp;
}

int a[100010];
int main(){
    int t;
    cin >> t;
    while (t--){
        int n;
        cin >> n;
        int leftMax = -1000000010;
        int maxSecond = 0;
        for (int i = 0; i < n; i ++){
            cin >> a[i];
            if(a[i] < leftMax){
                int diff = leftMax -a[i];
                int second = findMax(diff);
                if(second > maxSecond){
                    maxSecond = second;
                }
            }else{
                leftMax = a[i];
            }
        }
        cout << maxSecond << endl;
    }
}