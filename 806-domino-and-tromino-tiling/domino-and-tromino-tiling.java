class Solution {
    public int numTilings(int n) {
        long[] tilingWays = new long[n + 3];
        tilingWays[0] = 1;
        tilingWays[1] = 2;
        tilingWays[2] = 5;

        for (int i = 3; i < n; i++) {
            tilingWays[i] = (tilingWays[i - 1] * 2 + tilingWays[i - 3]) % 1000000007;
        }

        return (int) tilingWays[n - 1];
    }
}