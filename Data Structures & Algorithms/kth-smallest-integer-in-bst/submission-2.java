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
    public void kthSmallest(TreeNode root, List<Integer> smallestValues) {
        if (root == null)
            return;
        
        kthSmallest(root.left, smallestValues);
        smallestValues.add(root.val);
        kthSmallest(root.right, smallestValues);
    }


    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> arr = new ArrayList<>();
        kthSmallest(root, arr);
        return arr.get(k - 1);

    }
}
