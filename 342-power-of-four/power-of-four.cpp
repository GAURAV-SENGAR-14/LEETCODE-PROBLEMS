class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n <= 0) {
            return false;  // Powers of 4 are positive numbers
        }

        while(n % 4 == 0) {
            n = n / 4;  // Divide by 4 repeatedly
        }

        return n == 1;  // If we reach 1, it's a power of 4
    }
};