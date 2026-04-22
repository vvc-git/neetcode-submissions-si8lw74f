class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length, res = nums[0];

        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur += nums[j];
                res = Math.max(cur, res);
            }
        }
        return res;
    }
}
