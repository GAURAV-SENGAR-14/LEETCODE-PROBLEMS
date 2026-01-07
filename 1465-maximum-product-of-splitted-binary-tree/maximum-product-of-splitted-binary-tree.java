class Solution {
    long total = 0;
    long ans = 0;

    void findTotal(TreeNode root) {
        if(root == null) return;

        total += root.val;
        findTotal(root.left);
        findTotal(root.right);
    }

    long dfs(TreeNode root) {
        if(root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);
        long sum = left + right + root.val;

        long pro = sum * (total - sum);
        ans = Math.max(pro, ans);

        return sum;
    }

    public int maxProduct(TreeNode root) {
        findTotal(root);
        dfs(root);
        int MOD = 1000000007;

        return (int)(ans % MOD);
    }
}