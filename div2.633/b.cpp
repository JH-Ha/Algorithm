#include <iostream>
#include <algorithm>

using namespace std;
int a[100010];
int main(){
    int t;
    cin >> t;
    while (t --){
        int n;
        cin >> n;
        for (int i = 0; i < n; i ++){
            cin >> a[i];
        }
        sort(a, a+ n);
        if(n % 2== 1) {
            cout << a[n/2] << " ";
            for (int i = 1; i <= n/2 ; i ++){
                cout << a[n/2 + i ] << " " << a[n/2-i] << " ";
            }
        } else{
            for(int i = 0; i < n/2 ; i ++){
                cout << a[n/2 +i ] << " " << a[n/2 -i -1] << " ";
            }
        }
        cout << endl;
    }

}