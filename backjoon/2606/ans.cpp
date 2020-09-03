#include<iostream>
#include<vector>
#include<queue>

using namespace std;

vector<int> node[105];
bool vistied[105];
int main(){
    int n , e;
    cin >> n >> e;
    for(int i = 0; i < e; i ++){
        int l,r;
        cin >> l >> r;
        node[l].push_back(r);
        node[r].push_back(l);
    }
    for(int i = 0; i < n; i ++){
        vistied[i] = false;
    }
    queue<int> q;
    q.push(1);
    int ans = -1;
    while(!q.empty()){
        int top = q.front();
        q.pop();
        if(vistied[top]) continue;
        vistied[top] = true;
        ans ++;
        for(int i = 0; i < node[top].size(); i ++){
            q.push(node[top][i]);
        }
    }
    cout << ans << endl;
        
    return 0;
}