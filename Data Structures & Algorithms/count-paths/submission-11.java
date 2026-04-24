class Solution {
    int m, n;
    Map<String, Integer> memo = new HashMap<>();

    private int dfs(int i, int j) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            System.out.println("reused! " + key + " " + memo.get(key));
            return memo.get(key);
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        } 
            
        // bottom and down
        int down = dfs(i + 1, j);
        int right =  dfs(i, j + 1);
        memo.put(key, down+right);
        return down + right;
    }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        return dfs(0, 0);    
    }
}
