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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                sb.append("N,");
            } else {
                sb.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        System.out.println("serialize " + sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (!vals[index].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(curr.left);
            };
            index++;
            if (!vals[index].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(curr.right);
            };
            index++;
        }
        return root;
    }
}
