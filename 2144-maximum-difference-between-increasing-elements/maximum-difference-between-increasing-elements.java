class Solution {
    public int maximumDifference(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxSum = -1;
        for (int num : nums) {
            if (num <= minNum) {
                minNum = num;
            } else {
                maxSum = Math.max(maxSum, num - minNum);
            }
        }
        return maxSum;
    }
}