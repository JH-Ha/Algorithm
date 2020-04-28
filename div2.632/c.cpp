#include<iostream>
#include<utility>
#include<algorithm>

using namespace std;

long long sum[200010];

int main(){
    int n;
    cin >> n;
    int a;
    for (int i = 0; i< n; i ++){
        cin >> a;
        if(i == 0) sum[i] = a;
        else{
            sum[i] = sum[i-1] + a;
        }
    }
    sort(sum, sum + n);
    int result = 0;
    int startIdx = 0;
    for (int i = 0; i < n; i++){
        if(sum[i] != 0) result ++;
        if(i != 0){
            if(sum[i] != sum[i-1]){
                result += n - i;
            }
        }

        cout << sum[i] << endl;
    }
    cout << result << endl;

}