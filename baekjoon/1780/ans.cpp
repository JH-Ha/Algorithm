#include<iostream>

using namespace std;
int n;
int numOne = 0, numZero = 0, numMinus = 0;
int kami[2400][2400];
void findKami(int x, int y, int size){
    bool isOne = true;
    bool isMinus = true;
    bool isZero = true;
    for(int i = x; i < x + size; i ++){
        for(int j = y; j < y + size; j ++){
            if(kami[i][j] == 0){
                isOne = false;
                isMinus = false;
            } else if(kami[i][j] == 1){
                isZero = false;
                isMinus = false;
            } else if(kami[i][j] == -1){
                isZero = false;
                isOne = false;
            }
        }
    }
    if(isOne) numOne ++;
    else if(isZero) numZero ++;
    else if(isMinus) numMinus ++;
    else{
        int nextSize = size/3;
        for(int i= 0; i <3; i ++){
            for(int j = 0; j < 3; j ++){
                findKami(x + i*nextSize, y + j *nextSize, nextSize);
            }
        }

    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++){
            cin >> kami[i][j];
        }
    }
    findKami(0,0,n);
    cout << numMinus << '\n' 
    << numZero << '\n'
    << numOne << '\n';
    return 0;
}