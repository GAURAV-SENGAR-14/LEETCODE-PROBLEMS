
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> countMap = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + "," + b;
            count += countMap.getOrDefault(key, 0);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}

