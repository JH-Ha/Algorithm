#include <iostream>
#include <map>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        map<int, int> myMap;

        for (int i = 0; i < n; i++)
        {
            char c;
            int input;
            cin >> c >> input;
            map<int, int>::iterator iter;
            if (c == 'I')
            {
                iter = myMap.find(input);
                if (iter != myMap.end())
                {
                    iter->second++;
                }
                else
                {
                    myMap.insert(make_pair(input, 1));
                }
            }
            else if (c == 'D')
            {
                int num = myMap.size();
                if (num == 0)
                    continue;
                if (input == -1)
                {
                    auto ele = myMap.begin();
                    if (ele->second > 1)
                    {
                        ele->second--;
                    }
                    else
                    {
                        myMap.erase(myMap.begin());
                    }
                }
                else
                {
                    auto it = myMap.end();
                    it--;
                    if (it->second > 1)
                    {
                        it->second--;
                    }
                    else
                    {
                        myMap.erase(it);
                    }
                }
            }
        }
        if (myMap.size() == 0)
        {
            cout << "EMPTY" << '\n';
        }
        else
        {
            auto last = myMap.end();
            last--;
            cout << last->first << " " << myMap.begin()->first << '\n';
        }
    }
    return 0;
}