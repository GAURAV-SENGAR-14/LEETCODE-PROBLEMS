/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    *returnSize = digitsSize;

    if (digits[digitsSize - 1] < 9) {
        digits[digitsSize - 1]++;
        return digits;
    }

    int carry = 1;
    for (int i = digitsSize - 1; i >= 0; i--) {
        digits[i] += carry;
        carry = digits[i] / 10;
        digits[i] %= 10;

        if (carry == 0) return digits;
    }

    digits = realloc(digits, sizeof(int) * (digitsSize + 1));
    for (int i = digitsSize; i > 0; i--) {
        digits[i] = digits[i - 1];
    }
    digits[0] = 1;

    (*returnSize)++;
    return digits;
}