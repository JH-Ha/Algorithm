#include<iostream>
#include<utility>
//#include<algorithm>

using namespace std;

pair<int, int> people[52];

int main(){
    int n;
    cin >>n;
    for(int i = 0; i < n; i ++){
        int w, h;
        cin >> w >> h;
        people[i] = make_pair(w,h);
    }
    //sort(people, people + n);
    for(int i = 0; i < n; i ++){
        int rank = 1;
        for(int j = 0; j < n; j ++){
            if(i == j ) continue;
            if((people[i].first < people[j].first)
             && (people[i].second < people[j].second)){
                 rank++;
             }
        }
        cout << rank << " ";
    }
    cout << endl;
    return 0;
}