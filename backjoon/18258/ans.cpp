#include <iostream>
#include <queue>
#include <string>

using namespace std;
queue<int> s;

int main(void){
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    int n;
    cin >> n;
    string input;
    int num;
    while(n--){
        cin >> input ;
        if(input == "push"){
            cin >> num;
            s.push(num);
        } else if(input =="front"){
            if(s.size() == 0){
                cout << -1 << '\n';
            } else{
                cout << s.front() << '\n';
            }
        } else if(input == "back"){
            if(s.size() == 0){
                cout << - 1 << '\n';
            }else{
                cout << s.back() << '\n';
            }
        } else if(input == "size"){
            cout << s.size() << '\n';
        } else if(input == "empty"){
            if(s.size() == 0){
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else if(input == "pop"){
            if(s.size() == 0){
                cout << -1 << '\n';
            } else{
                cout << s.front() << '\n';
                s.pop();
            }
        }
    } 
    return 0;
}