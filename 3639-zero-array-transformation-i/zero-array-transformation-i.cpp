class Solution {
public:
    static bool isZeroArray(const vector<int>& a, const vector<vector<int>>& q) {
        const int n = a.size();
        const int m = q.size();
        const int bytes = sizeof(int) * (n + 1);
        int* p = (int*)alloca(bytes);
        memset(p, 0, bytes);
        for (int i = 0; i < m; ++i) {
            ++p[q[i][0]];
            --p[q[i][1] + 1];
        }
        for (int i = 0, d = 0; i < n; ++i) {
            d += p[i];
            if (a[i] - d > 0) return false;
        }
        return true;
    }
};