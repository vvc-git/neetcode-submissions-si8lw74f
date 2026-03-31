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
    public Node cloneGraph(Node node) {
        if (node == null) 
            return null;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> valToNode = new HashMap<>();;
        valToNode.put(node.val, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for (Node neighbor : cur.neighbors) {
                if (!valToNode.containsKey(neighbor.val)) {
                    valToNode.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                valToNode.get(cur.val).neighbors.add(valToNode.get(neighbor.val));
            }
        }
        return valToNode.get(node.val);
    }
}