class Solution:
    def minimumLength(self, s: str) -> int:
        frequency = Counter(s)

        min_length  = 0
        for _, freq in frequency.items():
            min_length += freq if freq <3 else (2 if freq%2==0 else 1)
        return min_length
        