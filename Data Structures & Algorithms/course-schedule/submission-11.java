class Solution {

    public boolean dfs(int node, Map<Integer, List<Integer>> req, Set<Integer> seen) {

        if (req.get(node).isEmpty())
            return true;
        
        if (seen.contains(node))
            return false;
        
        seen.add(node);
        for (int prereq : req.get(node)) {
            if (!dfs(prereq, req, seen))
                return false;
        }
        seen.remove(node);
        req.get(node).clear();
        return true;
    }



    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> req = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            req.put(i, new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            req.get(course).add(prereq);
        }



        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, req, seen))
                return false;
        }
        return true;
    }
}
