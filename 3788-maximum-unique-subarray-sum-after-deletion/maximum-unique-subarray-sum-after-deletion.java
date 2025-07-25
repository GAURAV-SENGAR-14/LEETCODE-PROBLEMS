class Solution 
{
    public int maxSum(int[] nums) 
    {
        // Step 1 : Initialization of Sum
        int totalSum = 0;

        // Step 2 : Initialization of Maximum Tracker
        int maxElement = Integer.MIN_VALUE;

        // Step 3 : Initialization of Uniqueness Set
        HashSet<Integer> used = new HashSet<>();

        // Step 4 : Iteration and Processing
        for (int num : nums) 
        {
            maxElement = Math.max(maxElement, num);
            if (num > 0 && used.add(num)) 
            {
                totalSum += num;
            }
        }

        // Step 5 : Final Decision (Edge Case Handling)
        return totalSum > 0 ? totalSum : maxElement;
    }
}