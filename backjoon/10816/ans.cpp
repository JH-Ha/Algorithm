#include <iostream>
#include <hash_map>
#include <utility>
#include <string>
using namespace std;
using namespace __gnu_cxx;


int main(){
    ios::sync_with_stdio(false); 
    int n;
    cin >> n;
    int card;
    hash_map<int, int> cardMap;
    hash_map<int,int>::iterator iter;
    for(int i = 0; i < n; i ++){
        cin >> card;
        iter = cardMap.find(card);
        if(iter != cardMap.end()){
            iter->second = iter->second + 1;
        }else{
            cardMap.insert(make_pair(card,1));
        }
    }
    int m;
    cin >> m;
    string result = "";
    for(int i = 0; i < m ; i ++){
        cin >> card;
        iter = cardMap.find(card);
        if(iter != cardMap.end()){
            //cout << iter->second << " ";
            result += to_string(iter->second) + " ";
        } else{
            //cout << 0 << " ";
            result += "0 ";
        }
    }
    cout << result << "\n";
    //cout << "\n";
    return 0;
}