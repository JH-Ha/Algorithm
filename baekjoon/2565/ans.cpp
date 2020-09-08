#include<iostream>
#include<utility>
#include<vector>
#include<algorithm>

using namespace std;

int n;

vector<pair<int,int>> denki;

int lis[505];

int main(){
    cin >> n;
    for(int i = 0; i < n; i ++){
        int l,r;
        cin >> l >> r;
        denki.push_back(make_pair(l,r));
    }
    sort(denki.begin(), denki.end());
    lis[0] = 1;
    int ans = 1;
    for(int i = 1; i < n; i ++){
        lis[i] = 0;
        for(int j = 0; j < i; j ++){
            if(denki[j].second < denki[i].second){
                lis[i] = max(lis[i], lis[j]);
            }
        }
        lis[i] ++;
        ans = max(lis[i], ans);
    }
    cout << n - ans << '\n';
    return 0;
}