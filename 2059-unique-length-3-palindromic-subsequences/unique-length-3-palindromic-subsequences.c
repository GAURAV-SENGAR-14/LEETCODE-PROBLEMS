int countPalindromicSubsequence(char* inputString) {
    // Arrays to store the minimum and maximum occurrences of each character in the input string
    int minExist[26];
    int maxExist[26];

    // Initialize arrays with default values
    for (int i = 0; i < 26; i++) {
        minExist[i] = INT_MAX;
        maxExist[i] = INT_MIN;
    }

    // Populate minExist and maxExist arrays
    for (int i = 0; inputString[i] != '\0'; i++) {
        int charIndex = inputString[i] - 'a';
        minExist[charIndex] = (minExist[charIndex] < i) ? minExist[charIndex] : i;
        maxExist[charIndex] = (maxExist[charIndex] > i) ? maxExist[charIndex] : i;
    }

    // Variable to store the final count of unique palindromic subsequences
    int uniqueCount = 0;

    // Iterate over each character in the alphabet
    for (int charIndex = 0; charIndex < 26; charIndex++) {
        // Check if the character has occurred in the input string
        if (minExist[charIndex] == INT_MAX || maxExist[charIndex] == INT_MIN) {
            continue; // No occurrences, move to the next character
        }

        // Set to store unique characters between the minimum and maximum occurrences
        char uniqueCharsBetween[CHAR_MAX];
        int uniqueCharsCount = 0;

        // Iterate over the characters between the minimum and maximum occurrences
        for (int j = minExist[charIndex] + 1; j < maxExist[charIndex]; j++) {
            int charExists = 0;
            for (int k = 0; k < uniqueCharsCount; k++) {
                if (uniqueCharsBetween[k] == inputString[j]) {
                    charExists = 1;
                    break;
                }
            }
            if (!charExists) {
                uniqueCharsBetween[uniqueCharsCount++] = inputString[j];
            }
        }

        // Add the count of unique characters between the occurrences to the final count
        uniqueCount += uniqueCharsCount;
    }

    // Return the total count of unique palindromic subsequences
    return uniqueCount;
}