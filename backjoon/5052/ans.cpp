#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    int t;
    cin >> t;
    while(t --){
        int n;
        cin >> n;
        vector<string> v;
        for(int i = 0; i < n ; i ++){
            string s;
            cin >> s;
            v.push_back(s);
        }
        sort(v.begin(), v.end());
        string prev;
        string result = "YES";
        for(int i = 1; i < n ; i++){
            string prev = v[i-1];
            string cur = v[i];
            if(cur.length() > prev.length()){
                bool isSame = true;
                for(int j = 0; j < prev.length(); j ++){
                    if(cur[j] != prev[j]) isSame = false;
                }
                if(isSame) result = "NO";
            }
            
        }
        cout << result << endl;
    }
    return 0;
}