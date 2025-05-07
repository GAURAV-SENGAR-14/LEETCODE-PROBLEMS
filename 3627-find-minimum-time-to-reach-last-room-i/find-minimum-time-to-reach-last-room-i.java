class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] minTime = new int[n][m];
        for(int[] is : minTime) Arrays.fill(is, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{-1, 0, 0}); 
        minTime[0][0] = 0;
        int[] rowD = {0, -1, 0, 1};
        int[] colD = {-1, 0, 1, 0};
        while(!pq.isEmpty()){
            int[] pairs = pq.poll();
            int time = pairs[0], row = pairs[1], col = pairs[2];
            int nextStep = time + 1;
            if (row == n - 1 && col == m - 1) return nextStep;
            for(int d = 0; d < 4; d++){
                int newRow = row + rowD[d];
                int newCol = col + colD[d];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    int newTime = nextStep;
                    if(newTime < moveTime[newRow][newCol]) newTime = moveTime[newRow][newCol];
                    if(minTime[newRow][newCol] > newTime){
                        pq.offer(new int[]{newTime, newRow, newCol});
                        minTime[newRow][newCol] = newTime;
                    }
                }
            }
        }
        return -1;
    }
}