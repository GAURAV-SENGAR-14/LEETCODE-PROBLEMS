class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int sump, sums;

        // Initialize counters for balls at both ends
        sump = (boxes.charAt(0) == '1') ? 1 : 0;
        sums = (boxes.charAt(n - 1) == '1') ? 1 : 0;

        // Calculate prefix array (left to right)
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + sump;
            if (boxes.charAt(i) == '1') {
                sump++; // Increment number of balls
            }
        }

        // Calculate suffix array (right to left)
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + sums;
            if (boxes.charAt(i) == '1') {
                sums++; // Increment number of balls
            }
        }

        // Combine prefix and suffix arrays
        for (int i = 0; i < n; i++) {
            prefix[i] += suffix[i];
        }

        return prefix; // Result is stored in prefix
    }
}