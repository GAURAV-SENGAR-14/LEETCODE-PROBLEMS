class Solution {
    public List<String> getLongestSubsequence(String[] s, int[] g) {
        List<String> ans = new ArrayList<>();
        int n = s.length;
        int curr = g[0];
        ans.add(s[0]);

        for (int i = 1; i < n; i++) {
            if (g[i] != curr) {
                curr ^= 1;
                ans.add(s[i]);
            }
        }
        return ans;
    }
}