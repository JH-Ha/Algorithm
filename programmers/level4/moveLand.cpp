#include <iostream>
#include <queue>

using namespace std;

int n;

int idx = 0;

bool isValid(int i, int j, int n)
{
    if (i < 0 || i >= n)
        return false;
    if (j < 0 || j >= n)
        return false;
    return true;
}

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int set[90010];

int findParent(int a)
{
    if (set[a] == a)
        return a;
    else
        return findParent(set[a]);
}

void uni(int a, int b)
{
    int pa = findParent(a);
    int pb = findParent(b);
    set[pa] = pb;
}

class Edge
{
public:
    int cost;
    pair<int, int> l;
    pair<int, int> r;
    Edge(int _cost, pair<int, int> _l, pair<int, int> _r)
    {
        cost = _cost;
        l = _l;
        r = _r;
    }
};

struct cmp
{
    bool operator()(Edge t, Edge u)
    {
        return t.cost > u.cost;
    }
};

int solution(vector<vector<int>> land, int height)
{
    int answer = 0;
    int n = land.size();
    int minX = 0;
    int minY = 0;
    int minValue = 10010;
    int visited[310][310];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            visited[i][j] = -1;
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (land[i][j] < minValue)
            {
                minX = i;
                minY = j;
                minValue = land[minX][minY];
            }
            queue<pair<int, int>> q;
            if (visited[i][j] == -1)
            {
                q.push({i, j});
                visited[i][j] = idx;

                while (!q.empty())
                {
                    pair<int, int> top = q.front();
                    q.pop();

                    for (int di = 0; di < 4; di++)
                    {
                        int nextX = top.first + dx[di];
                        int nextY = top.second + dy[di];
                        if (isValid(nextX, nextY, n) && visited[nextX][nextY] == -1 && abs(land[nextX][nextY] - land[top.first][top.second]) <= height)
                        {
                            visited[nextX][nextY] = idx;
                            q.push({nextX, nextY});
                        }
                    }
                }
                idx++;
            }
        }
    }
    for (int i = 0; i < idx; i++)
    {
        set[i] = i;
    }

    priority_queue<Edge, vector<Edge>, cmp> pq;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (isValid(i + 1, j, n) && (visited[i + 1][j] != visited[i][j]))
            {
                pq.push(Edge(abs(land[i + 1][j] - land[i][j]), {i, j}, {i + 1, j}));
            }
            if (isValid(i, j + 1, n) && (visited[i][j + 1] != visited[i][j]))
            {
                pq.push(Edge(abs(land[i][j + 1] - land[i][j]), {i, j + 1}, {i, j}));
            }
        }
    }

    while (!pq.empty())
    {
        Edge edge = pq.top();
        pq.pop();
        pair<int, int> l = edge.l;
        pair<int, int> r = edge.r;
        if (findParent(visited[l.first][l.second]) != findParent(visited[r.first][r.second]))
        {
            answer += edge.cost;
            uni(visited[l.first][l.second], visited[r.first][r.second]);
        }
    }
    cout << answer << endl;

    return answer;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        cin >> n;
        vector<vector<int>> land;
        for (int i = 0; i < n; i++)
        {
            vector<int> row;
            land.push_back(row);
            for (int j = 0; j < n; j++)
            {
                int input;
                cin >> input;
                land[i].push_back(input);
            }
        }
        int height;
        cin >> height;
        int answer = solution(land, height);

        cout << answer << endl;
    }
    return 0;
}