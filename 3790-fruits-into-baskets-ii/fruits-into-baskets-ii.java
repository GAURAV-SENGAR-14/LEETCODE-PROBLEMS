class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = fruits.length;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i]) {
                    res -= 1;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return res;
    }
}