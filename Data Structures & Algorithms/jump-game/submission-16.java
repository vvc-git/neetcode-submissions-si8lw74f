class Solution {
    int[] nums;
    int n;
    Map<Integer, Boolean> memo = new HashMap<>();


    public boolean dfs(int idx) {
        if (idx == n - 1) return true;
        if ((idx >= n) || (idx < n && nums[idx] == 0)) return false;
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        for (int i = nums[idx]; i > 0; i--) {
            if (i >= n)
                continue;
            if (dfs(i + idx)) {
                memo.put(i+idx, true);
                return true;
            }
        }
        memo.put(idx, false);
        return false;
    }


    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        return dfs(0);
    }
}
