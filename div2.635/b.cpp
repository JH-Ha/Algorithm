#include<iostream>
#include<string>
using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        int x, n, m;
        cin >> x >> n >> m;
        for(int i = 0; i < n; i ++){
            if(x <= 20) break;
            x = x/2 + 10;
            //cout << i + 1 << " " << x << endl;
        }
        for (int i = 0; i < m; i++){
            x -= 10;
        }
        string result = "NO";
        if(x <= 0) result = "YES";
        cout << result << endl;
    }
}