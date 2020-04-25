#include<iostream>
#include<string>

using namespace std;
int a[100010];
int b[100010];
bool aHas[100010][3];

int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j< 3; j ++){
                aHas[i][j] = false;
            }
        }
        for(int i = 0; i < n; i ++){
            cin >> a[i];
            if(i == 0) {
                aHas[i][a[i]+1] = true;
                continue;
            }
            aHas[i][0] = aHas[i-1][0];
            aHas[i][1] = aHas[i-1][1];
            aHas[i][2] = aHas[i-1][2];
            
            aHas[i][a[i]+1] = true;
        }
        string result ="YES";
        for(int i = 0; i< n; i ++){
            cin >> b[i];
            if(i == 0){
                if(a[i]!=b[i]) {
                    //cout << "a[i] " << a[i] << " b[i] " << b[i] << endl;
                    result = "NO";
                    continue;
                }
            } else{
                int pos;
                if(b[i] - a[i]> 0) pos = 2;
                else if(b[i] - a[i] < 0) pos =0;
                else continue;
                if(!aHas[i-1][pos]) result = "NO";
            }

        }
        cout << result << endl;
    }
}