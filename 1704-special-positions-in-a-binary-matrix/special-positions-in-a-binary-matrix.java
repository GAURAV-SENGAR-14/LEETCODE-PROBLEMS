class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1) {

                    boolean special = true;

                    for (int k = 0; k < n; k++) {
                        if (k != j && mat[i][k] == 1) {
                            special = false;
                            break;
                        }
                    }

                    for (int k = 0; k < m && special; k++) {
                        if (k != i && mat[k][j] == 1) {
                            special = false;
                            break;
                        }
                    }

                    if (special)
                        count++;
                }
            }
        }

        return count;
    }
}