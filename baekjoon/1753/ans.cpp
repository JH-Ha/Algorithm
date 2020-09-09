#include<iostream>
#include<utility>
#include<vector>
#include<stdint.h>
#include<queue>

using namespace std;

vector<pair<int, int>> node[20010];
int d[20010];
int INF = 999999999;
int main(){
    
    int v, e;
    cin >> v >> e;


    int start;
    cin >> start;
    for(int i = 0; i < e; i ++){
        int l,r, w;
        cin >> l >> r >> w;
        node[l].push_back(make_pair(r,w));
    }

    for(int i = 1; i <= v; i ++){
        d[i] = INF;
    }
    priority_queue<pair<int,int>> pq;
    pq.push(make_pair(0, start));
    d[start] = 0;
    while(!pq.empty()){
        int cost = -pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        for(int i = 0; i < node[cur].size(); i ++){
            int next = node[cur][i].first;
            int nextCost = node[cur][i].second;
            if(d[next] > cost + nextCost){
                d[next] = cost + nextCost;
                pq.push(make_pair(-d[next], next));
            }
        }
    }
    

    for(int i = 1; i <= v; i ++){
        if(i == start) cout << 0 << '\n';
        else if(d[i] == INF) cout << "INF" << '\n';
        else cout << d[i] << '\n';
    }
    return 0;
}