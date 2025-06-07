class Solution {
    public String clearStars(String s) {
        List<Integer>[] buckets = new ArrayList[26];
        for (int j = 0; j < 26; ++j) buckets[j] = new ArrayList<>();
        int mask = 0;
        StringBuilder res = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                int i = ch - 'a';
                buckets[i].add(res.length());
                mask |= 1 << i;
                res.append(ch);
            } else {
                int lowbit = mask & -mask;
                int i = Integer.numberOfTrailingZeros(lowbit);
                List<Integer> b = buckets[i];
                int pos = b.remove(b.size() - 1);
                if (b.isEmpty()) mask ^= lowbit;
                res.setCharAt(pos, '\0');
            }
        }
        StringBuilder ans = new StringBuilder(res.length());
        for (int j = 0; j < res.length(); ++j) {
            char c = res.charAt(j);
            if (c != '\0') ans.append(c);
        }
        return ans.toString();
    }
}