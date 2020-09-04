#include<iostream>
#include<algorithm>

using namespace std;



int n, m;

int numArr[500010];

int main(){
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    cin >> n ;
    int a;
    for(int i = 0; i < n; i ++){
        cin >> a;
        numArr[i] = a;
    }
    sort(numArr,numArr + n);
    
    cin >> m;
    for(int i = 0; i < m; i ++){
        cin >> a;
        // cout << a << endl;
        int start, end;
        start = 0;
        end = n -1;
        bool hasValue = false;
        while(start <= end){
            int k = (start + end) /2;
            if(numArr[k] == a){
                hasValue = true;
                break;
            }
            if(numArr[k] < a){
                start = k + 1;
            }else{
                end = k - 1;
            }
        }
        if(hasValue){
            cout << 1 << " ";
        } else{
            cout << 0 << " ";
        }
    }
    cout << endl;
    return 0;
}