#include<iostream>
#include<utility>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;
vector<pair<int,int>> item;
int bag[105][100010];
int main(){
    cin >> n >> k;
    for(int i = 0; i < n; i ++){
        int w, v;
        cin >> w >> v;
        item.push_back(make_pair(w,v));
    }
    for(int i = 0; i <= k; i ++){
        bag[0][i] = 0;
    }
    for(int i = 1; i <= n ; i ++){
        for(int j = 0; j <= k; j ++){
            if(j >= item[i-1].first){
                bag[i][j] = max(bag[i-1][j], item[i-1].second + bag[i-1][j - item[i-1].first]);
            } else{
                bag[i][j] = bag[i-1][j];
            }
            
        }
        
    }
    // for(int i = 0; i <=n ; i ++){
    //     for(int j = 0; j<=k ; j ++){
    //         cout << bag[i][j] << " ";
    //     }
    //     cout << '\n';
    // }
    cout << bag[n][k] << '\n';
    return 0;
}