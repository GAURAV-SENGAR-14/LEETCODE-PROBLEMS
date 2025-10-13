class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n=len(digits)
        carry=0

        for i in range(n-1,-1,-1):
            carry=(digits[i]+1)//10
            digits[i]=(digits[i]+1)%10

            if not carry:
                break
        
        return [carry]+digits if carry else digits
        
        