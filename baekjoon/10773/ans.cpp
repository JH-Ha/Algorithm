#include<stack>
#include<iostream>

using namespace std;

int n;
int main(){
    cin >> n;
    int input;
    stack<int> s;
    for(int i = 0; i < n; i ++){
        cin >> input;
        if(input == 0){
            s.pop();
        }else{
            s.push(input);
        }
    }
    long long sum = 0;
    while(!s.empty()){
        int ele = s.top();
        sum+= ele;
        s.pop();
    }
    cout << sum << '\n';
    return 0;
}