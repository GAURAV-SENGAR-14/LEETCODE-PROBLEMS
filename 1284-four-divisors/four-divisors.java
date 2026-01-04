class Solution {

    public int countDivisors(int n) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                count++;

                if (n / i != i) {
                    sum += n / i;
                    count++;
                }
            }
            if (count > 4)
                return 0;
        }

        if (count == 4)
            return sum;

        return 0;
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res += countDivisors(num);
        }

        return res;
    }
}