#include<iostream>
#include<string>

using namespace std;

string s, bomb;
char result[1000010];
int main(){
    cin >> s >> bomb;
    //for(int i = 0; i)
    int idx = 0;
    int bombLen = bomb.size();
    for(int i = 0; i < s.size(); i ++){
        result[idx] = s[i];
        idx ++;
        if(s[i] == bomb[bombLen - 1]){
            bool isSame = true;
            int bombIdx = 0;
            for(int j = idx - bombLen ; j <= idx -1; j ++){
                if(result[j] != bomb[bombIdx]){
                    isSame = false;
                }
                bombIdx ++;
            }
            if(isSame){
                for(int j = idx - bombLen; j <= idx -1; j ++){
                    result[j] = '\0';
                }
                idx = idx - bombLen ;
            }
        }
    }
    if(idx == 0)
        cout << "FRULA" << endl;
    else
        cout << result << endl;;
    return 0;
}