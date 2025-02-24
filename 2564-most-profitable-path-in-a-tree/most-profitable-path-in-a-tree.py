class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        def dfs(curr, prev, step):
            nonlocal n, adj, dist_from_bob

            max_income = 0                   # maximum income for alice
            max_income_leaf = float('-inf') # maximum income for a leaf   

            # explore neighbor of curr
            for neigh in adj[curr]:
                # not a cycle
                if neigh != prev:
                    # recur from neigh
                    temp = dfs(neigh, curr, step + 1)

                    # update
                    max_income_leaf = max(max_income_leaf, temp)

                    # already at optimum distance of can jump from neigh to curr
                    dist_from_bob[curr] = min(dist_from_bob[curr], 
                                              dist_from_bob[neigh] + 1)

            # action
            # 1. Alice reaches the node first
            if dist_from_bob[curr] > step:
                max_income += amount[curr]

            # 2. Alice and Bob reach the node at the same time
            elif dist_from_bob[curr] == step:
                max_income += amount[curr] // 2

            # if not reaching the leaf return max_income; otherwise include max_income_leaf
            return max_income if max_income_leaf == float('-inf') else max_income + max_income_leaf
                
        n = len(amount)

        # dist_from_bob[i] := min step to till Bob reaches ith node
        dist_from_bob = [n for _ in range(n)]
        dist_from_bob[bob] = 0

        # bidirectional adj list
        adj = defaultdict(list)
        for src, des in edges:
            adj[src] += [des]
            adj[des] += [src]

        # run dfs for Alice starting at index 0
        return dfs(0, 0, 0)