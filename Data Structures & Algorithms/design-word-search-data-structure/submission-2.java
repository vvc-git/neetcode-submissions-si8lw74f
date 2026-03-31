class WordDictionary {
    Node root = new Node();

    class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isEndOfWord = false;
    }

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            curr.next.putIfAbsent(c, new Node());
            curr = curr.next.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int wordIndex, Node node) {

        Node cur = node;

        for (int i = wordIndex; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (curLetter == '.') {
                for (Node child : cur.next.values()) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.next.containsKey(curLetter)) {
                    return false;
                }
                cur = cur.next.get(curLetter);
            }
        }
        return cur.isEndOfWord;
    }
}
