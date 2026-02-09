/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);;
        root=bst(arr,0,arr.size()-1);
        return root;
    }
    void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    TreeNode bst(ArrayList<Integer> arr,int s,int e){
        if(s>e) return null;
        int mid=(s+e)/2;

        TreeNode root=new TreeNode(arr.get(mid));
        root.left=bst(arr,s,mid-1);
        root.right=bst(arr,mid+1,e);

        return root;
    }
}