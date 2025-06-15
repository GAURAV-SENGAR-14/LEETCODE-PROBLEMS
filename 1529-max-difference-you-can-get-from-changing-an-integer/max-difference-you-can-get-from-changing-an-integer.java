class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);

        char maxTarget = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxTarget = c;
                break;
            }
        }
        String maxStr = s.replace(maxTarget, '9');

        String minStr = s;
        if (s.charAt(0) != '1') {
            minStr = s.replace(s.charAt(0), '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    minStr = s.replace(c, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}