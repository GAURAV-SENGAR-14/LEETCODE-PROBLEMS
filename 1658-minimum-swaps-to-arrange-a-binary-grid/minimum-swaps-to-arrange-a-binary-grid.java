class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zerosCount = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = n-1; j > 0 && grid[i][j] == 0; j--)
                zerosCount[i]++;
        }

        int swaps = 0;

        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n && zerosCount[j] < n-i-1)
                j++;

            if(j == n) return -1;

            swaps += j-i;

            while(j > i){
                int temp = zerosCount[j];
                zerosCount[j] = zerosCount[j-1];
                zerosCount[j-1] = temp;
                j--;
            }
        }

        return swaps;
    }
}