class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        def flushStack():
            if not isPresentR:
                res.extend(stack)
            else:
                for i in range(len(stack)):
                    res.append('R')
            stack.clear()

        res = []

        stack = []
        isPresentR = False
        for domino in dominoes:
            if domino == '.':
                stack.append('.')
                continue

            if domino == 'L':
                stack.append('L')

                if not isPresentR:
                    for i in stack:
                        res.append('L')
                else: 
                    for i in range(len(stack)//2):
                        res.append('R')
                    if len(stack) % 2 != 0:
                        res.append('.')
                    for i in range(len(stack)//2):
                        res.append('L')
                    isPresentR = False

                stack.clear()

            if domino == 'R':
                flushStack()
                stack.append('R')
                isPresentR = True

        flushStack()

        return "".join(res)