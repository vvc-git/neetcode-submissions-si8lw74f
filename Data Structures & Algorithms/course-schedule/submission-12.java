class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public boolean dfs(int node) {
        if (seen.contains(node))
            return false;

        seen.add(node);
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        seen.remove(node);
        graph.get(node).clear();
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        for (int node = 0; node < numCourses; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        } 
        return true;
        
    }
}
