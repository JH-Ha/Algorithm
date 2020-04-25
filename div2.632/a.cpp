#include<iostream>

using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        int m, n;
        cin >> m >> n;
        for(int i = 0; i< m; i ++){
            for(int j = 0; j < n; j ++){
                if (i == m-1 && j == n -1){
                    cout << "W";
                } else{
                    cout << "B";
                }
            }
            cout << endl;
        }
    } 
}