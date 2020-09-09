#include<iostream>
#include<algorithm>
using namespace std;

int main(){
    long long n, m;
    cin >> n >> m;
    long long left = n - m;
    long long right = m;
    long long top = n;
    int numFive = 0;
    int numTwo = 0;
    while(top > 0){
        numFive += top / 5;
        top /= 5;
    }
    top = n;
    while(top > 0){
        numTwo += top / 2;
        top /= 2;
    }
    while(left > 0){
        numFive -= left /5;
        left /= 5;
    }
    left = n - m;
    while(left > 0){
        numTwo -= left/2;
        left /=2;
    }
    while(right > 0){
        numFive -= right/5;
        right /=5;
    }
    right = m;
    while(right > 0){
        numTwo -= right/2;
        right /= 2;
    }
    cout << min(numFive, numTwo) << endl;
    return 0;
}