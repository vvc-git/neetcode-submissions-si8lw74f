class Solution {
    int[] nums;
    int n;


    public boolean dfs(int idx) {
        if (idx == n - 1) return true;
        if ((idx >= n) || (idx < n && nums[idx] == 0)) return false;

        for (int i = nums[idx]; i > 0; i--) {
            if (i >= n || i + idx >= n)
                continue;
            if (dfs( i + idx)) return true;
        }
        return false;
    }


    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        return dfs(0);
    }
}
