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
    public boolean areEqual(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
            return false;
        }

        if (n1.val != n2.val)
            return false;
        
        return areEqual(n1.left, n2.left) && areEqual(n1.right, n2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // First 
        if (root == null && subRoot == null)
            return true;

        if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        
        boolean result = false;
        if (root.val == subRoot.val)
            result = areEqual(root, subRoot);
        
        if (result) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        
    }
}
