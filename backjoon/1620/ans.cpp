#include<iostream>
#include<unordered_map>
#include<string>

using namespace std;
unordered_map<string, int> pocMap;
string pocArr[100010];

int main(){
    ios::sync_with_stdio(false); 
    int n, m;
    cin >> n >> m;
    for(int i =1; i <= n; i ++){
        string pocInput;
        cin >> pocInput;
        pocMap.insert(make_pair(pocInput, i));
        pocArr[i] = pocInput;
    }
    string ans = "";
    for(int i = 0; i < m ; i ++){
        string idx;
        cin >> idx;
        
        if(pocMap.find(idx) == pocMap.end()){
            //cout << pocArr[stoi(idx)] << '\n';
            ans += (pocArr[stoi(idx)] + '\n');
        }else{
            //cout << pocMap.find(idx)->second << '\n';
            ans += to_string(pocMap.find(idx)->second) + '\n';
        }
    }
    cout << ans ;
    return 0;
}