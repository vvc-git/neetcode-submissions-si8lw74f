class Solution {
    private Map<Character, Set<Character>> graph = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>();
    private List<Character> result = new ArrayList<>();

    // if key doesnt exist -> unvisited
    // if key exist and it is true -> visiting
    // if key exist and it is false (²) -> visited

    public boolean dfs(Character c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);
        for (Character nei : graph.get(c)) {
            if (dfs(nei)) return true;
        }
        visited.put(c, false);
        result.add(c);
        return false;
    }
    
    public String foreignDictionary(String[] words) {
        // Create a graph
        for (String w : words) {
            for (Character c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Fill this graph with constraints of words list
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() &&
                w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w2.charAt(j)).add(w1.charAt(j));
                    break;
                }
            }
        }

        // Traverse using topological sort...
        for (Character c : graph.keySet()) {
            if (dfs(c)) return "";
        }

        // Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
      
    }
}
