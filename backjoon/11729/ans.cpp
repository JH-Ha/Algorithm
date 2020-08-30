#include <iostream>
#include <utility>
#include <vector>

using namespace std;

vector<pair<int, int>> moving;
int findLeft(int a, int b)
{
    return 6 - a - b;
}

void honoi(int from, int to, int height)
{
    if (height == 0)
        return;
    int leftOne = findLeft(from, to);
    honoi(from, leftOne, height - 1);
    moving.push_back(make_pair(from, to));
    //cout << from << " " << to << "\n";
    honoi(leftOne, to, height - 1);
    //cout << from << " " << to << " height : " << height << endl;
}

int main()
{
    ios_base ::sync_with_stdio(false);
    int n;
    cin >> n;
    honoi(1, 3, n);
    cout << moving.size() << "\n";
    for (int i = 0; i < moving.size(); i++)
    {
        cout << moving[i].first << " " << moving[i].second << "\n";
    }
    return 0;
}