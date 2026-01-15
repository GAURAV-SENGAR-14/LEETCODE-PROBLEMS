class Solution {
    private int find(int[] bars){
        Arrays.sort(bars);
        int longest = 1, curr = 1;
        for (int i = 1; i < bars.length; i++){
            if (bars[i] == bars[i - 1] + 1){
                curr++;
                longest = Math.max(longest, curr);
            } else {
                curr = 1;
            }
        }
        return longest;
            
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int side = 1 + Math.min(find(hBars), find(vBars));
        return side * side;
    }
}