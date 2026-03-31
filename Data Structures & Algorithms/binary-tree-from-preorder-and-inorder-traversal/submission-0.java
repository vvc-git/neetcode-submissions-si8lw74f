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

    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;


    public TreeNode dfs(int[] preorder, int l, int r) {
        // We need to do some checkings
        if (l > r)
            return null;
        
        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        node.left = dfs(preorder, l, mid - 1);
        node.right = dfs(preorder, mid + 1, r);
        return node;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, 0, preorder.length - 1);
        return root;
    }
}
