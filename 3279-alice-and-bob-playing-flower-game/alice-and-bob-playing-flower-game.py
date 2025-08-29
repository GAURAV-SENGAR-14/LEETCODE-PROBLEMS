class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        odd = (n + 1) // 2    # odd count from n
        even = m // 2         # even count from m
        odd1 = (m + 1) // 2   # odd count from m
        even1 = n // 2        # even count from n

        return odd1 * even1 + odd * even