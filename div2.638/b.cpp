#include <iostream>
#include <cmath>
 
using namespace std;
 
bool isShown[105];
int a[105];
int main(){
    int t;
    cin >> t;
    while(t--){
        int n, k;
        cin >> n >> k;
 
        for(int i = 0; i< 105; i ++){
            isShown[i] = false;
        }
        int numDifferent = 0;
        for(int i = 0; i < n ; i++){
            cin >> a[i];
            if(isShown[a[i]] == false){
                isShown[a[i]] = true;
                numDifferent ++;
            }
        }
        //cout << numDifferent << endl;
        if(k < numDifferent){
            cout << -1 << endl;
            continue;
        } 
        int diff = k - numDifferent ;
        for(int i = 1; i < 105; i ++){
            if(diff == 0) break;
            if(isShown[i]== false){
                isShown[i] = true;
                diff --;
            }
        }
        cout << n * k << endl;
        for(int i= 0; i<n; i ++){
            for(int j = 1; j <= n; j ++){
                if(isShown[j])
                    cout << j  << " " ;
            }
        }
        cout << endl;
    }
    return 0;
}