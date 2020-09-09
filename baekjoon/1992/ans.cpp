#include<iostream>
#include<string>
using namespace std;
int n;
int img[65][65];

void quad(int x, int y, int size);

void quadOne(int x, int y, int size){
    bool isWhite = true;
    bool isBlack = true;
    for(int i = x; i < x + size/2; i ++){
        for(int j = y; j < y + size/2; j ++){
            if(img[i][j] == 0) isBlack = false;
            else isWhite = false;
            //cout << "img[" << i << "][" << j <<"] : " << img[i][j] << endl;
        }
    }
    if(isWhite) cout << "0";
    if(isBlack) cout << "1";
    if(!isWhite && ! isBlack){
        //cout <<"x : " << x << " y: " << y << " size/2 : " << size/2<< endl;
        quad(x,y, size/2);
    }
}

void quad(int x, int y, int size){
    cout << "(";
    quadOne(x,y,size);
    quadOne(x,y + size/2, size);
    quadOne(x+size/2,y, size);
    quadOne(x+size/2,y+ size/2, size);
    cout << ")";
}

int main(){
    
    cin >> n;
    for(int i = 0 ; i < n ; i ++){
        string input;
        cin >> input;
        for(int j = 0; j < n; j ++){
            img[i][j] = (input[j] - '0');
        }
    }
    quadOne(0,0,n * 2);
    cout << "\n";
    return 0;
}