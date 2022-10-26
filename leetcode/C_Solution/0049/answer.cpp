
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<string, vector<string>> map;
        vector<vector<string>> answer;
        for (int i = 0; i < strs.size(); i++)
        {
            string s = string(strs[i]);
            sort(s.begin(), s.end());
            auto found = map.find(s);
            if (found == map.end())
            {
                vector<string> vs;
                vs.push_back(strs[i]);
                map.insert({s, vs});
            }
            else
            {
                found->second.push_back(strs[i]);
            }
        }
        for (auto ele : map)
        {
            answer.push_back(ele.second);
        }
        return answer;
    }
};

int main()
{
    Solution Solution;
    vector<string> input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    Solution.groupAnagrams(input);
    return 0;
}