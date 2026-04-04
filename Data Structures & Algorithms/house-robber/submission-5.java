class Solution {
    int[] nums;
    Map<Integer, Integer> visited = new HashMap<>();

    public int dfs(int i) {
        if (i < 0 || i >= nums.length) {
            return 0;
        }
        
        if (visited.containsKey(i)) {
            return visited.get(i);
        }

        int result = Math.max(nums[i] + dfs(i+2), dfs(i+1));
        visited.put(i, result);
        return result;
    }


    public int rob(int[] nums) {
        this.nums = nums;
        return dfs(0);
    }
}
