class Solution {
    public int findPoisonedDuration(int[] time, int d) {
        int total_duration=0;
        for(int i=0,prev_end=time[0]-1;i<time.length;prev_end=time[i]+d-1,i++) 
        total_duration+=time[i]<=prev_end?d-(prev_end-time[i]+1):d;
        return total_duration;
    }
}