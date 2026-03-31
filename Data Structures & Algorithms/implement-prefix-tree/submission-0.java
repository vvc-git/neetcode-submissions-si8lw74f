class PrefixTree {

    NodeTree root;


    class NodeTree {
        Character value;
        Map<Character, NodeTree> next = new HashMap<>();
        boolean isEnd = false;

        public NodeTree(Character value) {
            this.value = value;;
        }
     }

    public PrefixTree() {
        this.root = new NodeTree('-');
    }

    public void insert(String word) {
        NodeTree node = this.root;
        
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                NodeTree newNode = new NodeTree(c);
                node.next.put(c, newNode);
            }
            node = node.next.get(c);
        } 
        node.isEnd = true;  
    }

    public boolean search(String word) {
        NodeTree node = this.root;

        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
        } 
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        NodeTree node = this.root;
        
        for (char c : prefix.toCharArray()) {
            System.out.printf("%s", node.value);
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
        } 
        return true;
    }
}
