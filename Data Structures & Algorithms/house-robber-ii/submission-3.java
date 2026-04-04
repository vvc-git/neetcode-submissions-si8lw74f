class Solution {


    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        if (nums.length < 4) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i], max);
            }
            return max;
        }

        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];

        // From first to second-to-last (Remove the last house)
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i-2], dp1[i - 1]);
        }

        // From second to the last (Remove the first house)
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i ++) {
            dp2[i-1] = Math.max(nums[i] + dp2[i-2-1], dp2[i-1-1]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);

    }
}
