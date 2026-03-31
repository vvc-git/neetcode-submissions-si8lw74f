class Solution {

    Set<Integer> seen = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean hasCycle(int node, int parent) {
        if (seen.contains(node))
            return true;
        
        seen.add(node);
        System.out.println(seen.size());
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent && hasCycle(neighbor, node))
                return true;
        }
        return false;

    }

    public boolean validTree(int n, int[][] edges) {

        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());;
        }

        for (int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return !hasCycle(0, -1) && seen.size() == n;

    }
}
