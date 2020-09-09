#include<queue>
#include<iostream>
#include<utility>
#include<vector>

using namespace std;
vector<pair<int,int>> node[810];
int d1[810];
int d2[810];
int dEnd[810];
int INF = 999999999;
int n, e;

void dijkstra(int start, int * d){
    priority_queue<pair<int,int>> pq;
    pq.push(make_pair(0, start));
    d[start] = 0;
    // for (int i = 1; i <= n; i ++){
    //     cout << d[i] << " ";
    // }
    //cout << endl;
    while(!pq.empty()){
        int cost = - pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        //cout << "cost : " << cost << " cur : " << cur << endl;
        for(int i = 0; i < node[cur].size(); i ++){
            int next = node[cur][i].first;
            int nCost = node[cur][i].second;
            //cout << "next : " << next << " nCost : " << nCost << endl;
            if(cost + nCost < d[next]){
                d[next] = cost + nCost;
                pq.push(make_pair(- d[next], next));
            }
        }
    }
}

int main(){
    
    cin >> n >> e;
    for(int i = 0; i < e; i ++){
        int l,r,w;
        cin >> l >> r >> w;
        node[l].push_back(make_pair(r,w));
        node[r].push_back(make_pair(l,w));
    }
    int start = 1, m1, m2, end = n;
    cin >> m1 >> m2;
    
    for(int i = 0; i <= n; i ++){
        d1[i] = d2[i] = dEnd[i] = INF;
    }
    dijkstra(1, d1);
    dijkstra(m1, d2);
    dijkstra(m2, dEnd);

    // for(int i = 1; i <= n; i ++){
    //     cout << d1[i] << " " ;
    // }
    //cout << endl;
    if(d1[m1] == INF || d2[m2] == INF|| dEnd[n] == INF){
        cout << -1 << endl;
    }else{
        int ans = min(d1[m1] + d2[m2] + dEnd[n], d1[m2] + dEnd[m1] + d2[n]);
        cout << ans << endl;
    }
    
    return 0;
}