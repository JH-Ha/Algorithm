#include<iostream>
#include<string>
#include<queue>
#include<utility>
#include<algorithm>

using namespace std;

int map[26][26];
int visited[26][26];
int danji[700];
int numDanji = 0;
int main(){
    int n;
    cin >> n;
    string s;
    for(int i = 0; i < n; i ++){
        cin >> s;
        for(int j = 0; j < n; j ++){
            map[i][j] = s[j] - '0';
            visited[i][j] = false;
        }
    }

    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++){
            if(map[i][j] == 0) continue;
            if(visited[i][j]) continue;
            //visited[i][j] = true;
            numDanji ++;
            danji[numDanji] = 0;

            queue<pair<int,int>> q;
            q.push(make_pair(i,j));
            while(!q.empty()){
                pair<int,int> front = q.front();
                q.pop();
                if(visited[front.first][front.second]) continue;
                visited[front.first][front.second] = true;
                danji[numDanji] ++;
                if(front.first > 0 && map[front.first-1][front.second] == 1) 
                    q.push(make_pair(front.first-1, front.second));
                if(front.first < n -1 && map[front.first + 1][front.second] == 1)
                    q.push(make_pair(front.first+1, front.second));
                if(front.second > 0 && map[front.first][front.second -1] == 1)
                    q.push(make_pair(front.first, front.second-1));
                if(front.second < n - 1 && map[front.first][front.second +1] == 1)
                    q.push(make_pair(front.first, front.second+1));
            }
        }
    }
    sort(danji+1, danji + numDanji + 1);
    cout << numDanji << endl;
    for(int i = 1; i <= numDanji; i ++){
        cout << danji[i] << "\n";
    }
    return 0;
}