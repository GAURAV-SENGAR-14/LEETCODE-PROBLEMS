class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int asciis1 = 0, asciis2 = 0;
        int n = s1.length(), m = s2.length();

        for(int i = 0; i < n ; i++){
            asciis1 += s1.charAt(i);
        }
        for(int i = 0 ; i < m ; i++){
            asciis2 += s2.charAt(i);
        }

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return asciis1 + asciis2 - 2 * dp[n][m];
    }
}