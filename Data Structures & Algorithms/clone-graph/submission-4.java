/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public void dfs(Node node) {
        if (node == null)
            return;

        Node copy = new Node(node.val);
        map.putIfAbsent(copy.val, copy);

        for (Node nei : node.neighbors) {
            if (!map.containsKey(nei.val)) {
                dfs(nei);
            }
            if (!map.get(nei.val).neighbors.contains(copy)) {
                map.get(nei.val).neighbors.add(copy);
                copy.neighbors.add(map.get(nei.val));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        dfs(node);
        return map.get(node.val);

    }
}