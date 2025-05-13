class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        import numpy as np

        MOD = int(1e9) + 7
        op_mat = np.zeros((26, 26), dtype=object)
        op_mat[0][-1] = op_mat[1][-1] = 1
        for i in range(1, 26):
            op_mat[i][i - 1] = 1
        power_mat = op_mat
        exponent = t        
        trans_mat = np.eye(26, dtype=object)
        while exponent > 0:
            if exponent & 1 != 0:
                trans_mat = (trans_mat @ power_mat) % MOD
            power_mat = (power_mat @ power_mat) % MOD
            exponent >>= 1

        curr_histo = [0 for _ in range(26)]
        for ch in s:
            curr_histo[ord(ch) - ord('a')] += 1
        result = sum((trans_mat @ np.array(curr_histo, dtype=object)) % MOD) % MOD
        return result