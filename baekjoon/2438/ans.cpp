#include<iostream>
#include<string>
using namespace std;

int main(){
    int n;
    cin >>n;
    string result = "";
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < i + 1; j ++){
            result = result + "*";
        }
        if(i != n-1){
            result +="\n";
        }
    }
    cout << result << endl;
    return 0;
}