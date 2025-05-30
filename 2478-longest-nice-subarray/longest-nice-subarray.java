class Solution {

    public int longestNiceSubarray(int[] nums) {
        int usedBits = 0; // Tracks bits used in current window
        int windowStart = 0; // Start position of current window
        int maxLength = 0; // Length of longest nice subarray found

        for (int windowEnd = 0; windowEnd < nums.length; ++windowEnd) {
            // If current number shares bits with window, shrink window from left
            // until there's no bit conflict
            while ((usedBits & nums[windowEnd]) != 0) {
                usedBits ^= nums[windowStart]; // Remove leftmost element's bits
                windowStart++;
            }

            
            usedBits |= nums[windowEnd];

   
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}