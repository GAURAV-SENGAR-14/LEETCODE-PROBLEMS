class currstate{
    public:
    int time;
    int x;
    int y;
    int inc;
};

class compare{
    public:
    bool operator()(currstate a, currstate b){
        return a.time > b.time;
    }
};

class Solution {
public:
    int minTimeToReach(vector<vector<int>>& moveTime) {
        int n = moveTime.size();
        int m = moveTime[0].size();

        priority_queue<currstate, vector<currstate>, compare> pq;
        vector<vector<bool>> visited(n, vector<bool>(m, 0));
        pq.push({0,0,0,0});

        while(!pq.empty()){
            auto top = pq.top();
            pq.pop();
            int currTime = top.time;
            int x = top.x;
            int y = top.y;
            int t = top.inc ? 2 : 1;
            bool inc = !top.inc;

            visited[x][y] = true;
            moveTime[x][y] = currTime;

            if(x == n-1 && y == m-1) break;

            if(x-1 >= 0 && !visited[x-1][y]){
                if(currTime >= moveTime[x-1][y]) pq.push({currTime+t, x-1, y, inc});
                else pq.push({moveTime[x-1][y]+t, x-1, y, inc});
                visited[x-1][y] = true;
            }

            if(x+1 < n && !visited[x+1][y]){
                if(currTime >= moveTime[x+1][y]) pq.push({currTime+t, x+1, y, inc});
                else pq.push({moveTime[x+1][y]+t, x+1, y, inc});
                visited[x+1][y] = true;
            }

            if(y-1 >= 0 && !visited[x][y-1]){
                if(currTime >= moveTime[x][y-1]) pq.push({currTime+t, x, y-1, inc});
                else pq.push({moveTime[x][y-1]+t, x, y-1, inc});
                visited[x][y-1] = true;
            }

            if(y+1 < m && !visited[x][y+1]){
                if(currTime >= moveTime[x][y+1]) pq.push({currTime+t, x, y+1, inc});
                else pq.push({moveTime[x][y+1]+t, x, y+1, inc});
                visited[x][y+1] = true;
            }

        }

        return moveTime[n-1][m-1];
    }
};