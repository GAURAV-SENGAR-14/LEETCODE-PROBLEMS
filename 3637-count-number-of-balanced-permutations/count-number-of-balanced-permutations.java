class Solution {
    int MOD = 1000000007;
    int n, totalSum;
    int[] digits;
    Long[][][] dp;
    long[] fact, invFact;

    public int countBalancedPermutations(String num) {
        n = num.length();
        digits = new int[n];
        totalSum = 0;
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
            totalSum += digits[i];
        }
        if ((totalSum & 1) == 1) return 0;
        int target = totalSum / 2;
        int evens = n / 2;

        dp = new Long[n+1][evens+1][target+1];
        precomputeFactorials(n);

        long waysToChoose = solve(0, evens, target);

        long ans = waysToChoose * fact[evens] % MOD * fact[n-evens] % MOD;
        int[] freq = new int[10];
        for (char c : num.toCharArray()) freq[c - '0']++;
        for (int f : freq) ans = ans * invFact[f] % MOD;

        return (int) ans;
    }

    private long solve(int pos, int taken, int sum) {
        if (taken == 0 && sum == 0) return 1;
        if (pos == n || taken < 0 || sum < 0) return 0;
        if (dp[pos][taken][sum] != null) return dp[pos][taken][sum];

        long res = solve(pos+1, taken, sum)
                 + solve(pos+1, taken-1, sum - digits[pos]);
        return dp[pos][taken][sum] = res % MOD;
    }

    void precomputeFactorials(int N) {
        fact = new long[N+1];
        invFact = new long[N+1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) fact[i] = fact[i-1] * i % MOD;
        invFact[N] = modInverse(fact[N]);
        for (int i = N; i >= 1; i--) invFact[i-1] = invFact[i] * i % MOD;
    }

    long modInverse(long x) { return modPow(x, MOD-2); }
    long modPow(long a, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return r;
    }
}