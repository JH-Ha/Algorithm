#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

vector<pair<int, int>> meetingVector;

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int start, end;
        cin >> start >> end;
        pair<int, int> meeting = make_pair(end, start);
        meetingVector.push_back(meeting);
    }
    sort(meetingVector.begin(), meetingVector.end());
    int end = meetingVector[0].first;
    int ans = 1;
    for (int i = 1; i < n; i++)
    {
        if (meetingVector[i].second >= end)
        {
            end = meetingVector[i].first;
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}