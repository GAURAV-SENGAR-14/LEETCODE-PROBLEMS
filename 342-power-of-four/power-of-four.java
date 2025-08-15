class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}