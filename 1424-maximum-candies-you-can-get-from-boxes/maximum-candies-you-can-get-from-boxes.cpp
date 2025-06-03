class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies,
                   vector<vector<int>>& keys,
                   vector<vector<int>>& containedBoxes,
                   vector<int>& initialBoxes) {
        queue<int> q;
        int n = status.size();
        vector<bool> vis(n, false), found(n, false);
        for (auto i : initialBoxes) {
            if (status[i]) {
                q.push(i);
                vis[i] = true;
            }
            found[i] = true;
        }
        int res = 0;
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            res += candies[i];
            for (auto k : keys[i]) {
                status[k] = 1;
                if (!vis[k] && found[k]) {
                    vis[k] = true;
                    q.push(k);
                }
            }
            for (auto b : containedBoxes[i]) {
                found[b] = true;
                if (!vis[b] && status[b] == 1) {
                    vis[b] = true;
                    q.push(b);
                }
            }
        }
        return res;
    }
};