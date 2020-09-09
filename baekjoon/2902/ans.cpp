#include<iostream>
#include<string>
using namespace std;

int main(){
    string s;
    cin >> s;
    string ans ="";
    ans += s[0];
    for(int i = 1; i < s.size() - 1; i ++){
        if(s[i] == '-'){
            ans += s[i + 1];
        }
    }
    cout << ans << '\n';
    return 0;
}