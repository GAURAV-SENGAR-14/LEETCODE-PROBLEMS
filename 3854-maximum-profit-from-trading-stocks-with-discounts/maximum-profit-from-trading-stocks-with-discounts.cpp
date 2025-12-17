class Solution {
public:
    int N, budget;
    vector<int> present, future;
    map<pair<int, int>, vector<int>> dp;
    unordered_map<int, vector<int>> adj;

    vector<int> dfs (int node, int discount) {
        auto key = make_pair(node, discount);
        if (dp.find(key) != dp.end()) {
            return dp[key];
        }

        // Case 1: dont take the current node, discount is not considered (discount is 0)
        vector<int> notTake(budget + 1, 0);
        for (int childNode: adj[node]) {
            vector<int> childVec = dfs(childNode, 0);
            vector<int> temp(budget + 1, 0);

            for (int b = 0; b <= budget; b++) {
                for (int k = 0; k <= b; k++) {
                    temp[b] = max(temp[b], notTake[k] + childVec[b - k]);
                }
            }

            notTake = temp;
        }

        // Case 2: take the current node, discount is considered (discount is 1)
        int price = (discount ? present[node] / 2 : present[node]);
        int profit = future[node] - price;

        vector<int> take(budget + 1, 0);
        for (int childNode: adj[node]) {
            vector<int> childVec = dfs(childNode, 1);
            vector<int> temp(budget + 1);

            for (int b = 0; b <= budget; b++) {
                for (int k = 0; k <= b; k++) {
                    temp[b] = max(temp[b], take[k] + childVec[b - k]);
                }
            }
            
            take = temp;
        }

        vector<int> takeProfit(budget + 1, -1e9);
        vector<int> ans(budget + 1);

        for (int b = 0; b <= budget; b++) {
            if (b >= price) {
                takeProfit[b] = profit + take[b - price];
            }

            ans[b] = max({notTake[b], takeProfit[b], 0});
        }
        
        return dp[key] = ans;
    }

    int maxProfit(int n, vector<int>& _present, vector<int>& _future, vector<vector<int>>& hierarchy, int b) {
        N = n;
        present = _present;
        future = _future;
        budget = b;

        for (vector<int>& nums: hierarchy) {
            int u = nums[0] - 1, v = nums[1] - 1;
            adj[u].push_back(v);
        }

        vector<int> ans = dfs(0, 0);
        return *max_element(ans.begin(), ans.end());
    }
};