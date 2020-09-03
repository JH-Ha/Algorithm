#include<iostream>
#include<string>
using namespace std;

int main(){
    string s;
    cin >> s;
    bool isPal = true;
    for(int i = 0; i < s.size()/ 2; i ++){
        if(s[i] != s[s.size()-1 -i]) isPal = false;
    }
    if(isPal) cout << "1" << "\n";
    else cout << "0" << "\n";
    return 0;
}