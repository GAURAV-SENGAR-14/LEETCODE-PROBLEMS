class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(0);
        int cnt = 1;
        for (int i = 1; i < sb.length(); ) {
            char ch = sb.charAt(i);
            if (ch == c) {
                cnt++;
            } else {
                c = ch;
                cnt = 1;
            }
            if (cnt > 2) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}