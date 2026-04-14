class Solution {
    int[] nums;
    Map<Integer, Integer> memo = new HashMap<>();

    public int dfs(int begin) {
        //System.out.println("dfs starting with: " + begin +  "-> nums[begin]: " + nums[begin]);
        if (begin == nums.length) {
            return 0;
        }

        if (memo.containsKey(begin)) {
            return memo.get(begin);
        }

        int res = 1;
        memo.put(begin, 1);
        for (int end = begin; end < nums.length; end++) {
            //System.out.println("begin: " + begin + "-> nums[begin]: " + nums[begin] + " || end: " + end + "-> nums[end]: " + nums[end]);
            if (nums[begin] >= nums[end]) {
                continue;
            }
            res = Math.max(res, dfs(end) + 1);
            
            //System.out.println("res in: " + res);
        }
        memo.put(begin, res);
        return res;
    }


    public int lengthOfLIS(int[] nums) {
        this.nums = nums;

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(i));
        }
        return max;
    }
}
