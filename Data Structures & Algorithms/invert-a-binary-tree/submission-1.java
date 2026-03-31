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

    private TreeNode invertSubTree(TreeNode root) {

        // It is leaf node
        if (root == null) {
            return null;
        }
        TreeNode left = invertSubTree(root.right);
        TreeNode right = invertSubTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return invertSubTree(root);
    }
}
