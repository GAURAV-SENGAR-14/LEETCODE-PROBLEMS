class Solution {
  boolean ans = false;
    char[] signs;

    void solve(int idx, int[] cards, Object[] cardsWithSign, boolean[] v, boolean isSign) {
        if (ans) return;
        if (idx == 7) {
            CheckWithBrackets(cardsWithSign);
             return;
        }
        if (isSign) {
            for (int s = 0; s < 4; s++) {
                cardsWithSign[idx] = signs[s];
                 solve(idx + 1, cards, cardsWithSign, v, false);
                if (ans) return;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!v[i]) {
                    v[i] = true;
                    cardsWithSign[idx] = cards[i];
                    solve(idx + 1, cards, cardsWithSign, v, true);
                    v[i] = false;
                    if (ans) return;
                 }
            }
        }
    }

    private Double apply(double x, double y, char op) {
        final double EPS = 1e-9;
         switch (op) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/':
                if (Math.abs(y) < EPS) return null;
                return x / y;
        }
         return null;
    }

    void CheckWithBrackets(Object[] t) {
        final double EPS = 1e-6;
        final double TARGET = 24.0;

          double a = ((Integer) t[0]).doubleValue();
           double b = ((Integer) t[2]).doubleValue();
          double c = ((Integer) t[4]).doubleValue();
          double d = ((Integer) t[6]).doubleValue();

        char op1 = ((Character) t[1]).charValue();
        char op2 = ((Character) t[3]).charValue();
        char op3 = ((Character) t[5]).charValue();

         Double r1 = apply(a, b, op1);
        if (r1 != null) {
            Double r12 = apply(r1, c, op2);
            if (r12 != null) {
                Double r123 = apply(r12, d, op3);
                if (r123 != null && Math.abs(r123 - TARGET) < EPS) { ans = true; return; }
            }
        }

        Double r2 = apply(b, c, op2);
        if (r2 != null) {
            Double r21 = apply(a, r2, op1);
            if (r21 != null) {
                Double r213 = apply(r21, d, op3);
                if (r213 != null && Math.abs(r213 - TARGET) < EPS) { ans = true; return; }
            }
        }

        if (r2 != null) {
            Double r23 = apply(r2, d, op3);
            if (r23 != null) {
                Double r3 = apply(a, r23, op1);
                if (r3 != null && Math.abs(r3 - TARGET) < EPS) { ans = true; return; }
            }
        }

        Double r4 = apply(c, d, op3);
        if (r4 != null) {
            Double r42 = apply(b, r4, op2);
            if (r42 != null) {
                Double r421 = apply(a, r42, op1);
                if (r421 != null && Math.abs(r421 - TARGET) < EPS) { ans = true; return; }
            }
        }

        if (r1 != null && r4 != null) {
            Double rFinal = apply(r1, r4, op2);
            if (rFinal != null && Math.abs(rFinal - TARGET) < EPS) { ans = true; return; }
        }
    }

    public boolean judgePoint24(int[] cards) {
        signs = new char[] {'+', '-', '/', '*'};
         Object[] cardsWithSign = new Object[7];
         boolean[] visitedcards = new boolean[4];
         solve(0, cards, cardsWithSign, visitedcards, false);
         return ans;
    }
}