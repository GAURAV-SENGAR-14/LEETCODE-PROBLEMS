class Solution {
private:
    bool canCross(int m, int n, vector<vector<int>>& cells, int day) {
        // Create grid (0 = land, 1 = water)
        vector<vector<int>> grid(m, vector<int>(n, 0));
        
        // Mark water cells up to the current 'day'
        for (int i = 0; i < day; ++i) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        // BFS Setup
        queue<pair<int, int>> q;
        
        // Add all valid starting points from the TOP row
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 0) {
                q.push({0, j});
                grid[0][j] = 1; // Mark as visited
            }
        }

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        // Standard BFS
        while (!q.empty()) {
            auto [r, c] = q.front();
            q.pop();

            // If we reached the BOTTOM row
            if (r == m - 1) return true;

            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check bounds and if cell is Land (0)
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; // Mark as visited
                    q.push({nr, nc});
                }
            }
        }
        return false;
    }

public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        int m = row;
        int n = col;
        
        int left = 1;
        int right = cells.size(); // Total days
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canCross(m, n, cells, mid)) {
                ans = mid;      // This day works, try a later day
                left = mid + 1;
            } else {
                right = mid - 1; // This day failed, try an earlier day
            }
        }
        return ans;
    }
};