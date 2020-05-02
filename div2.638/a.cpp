#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int t;
    cin >> t;

    for(int i = 0; i< t; i ++){
        int n;
        cin >> n;
        long long lowSum = 0;
        for(int j = 0; j< n/2 -1; j ++){
            lowSum += pow(2, j+1);
        }
        cout << lowSum * 2 + 2 << endl;
    }
    return 0;
}