class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int size;
    int target;
    int[] nums;


    public void dfs(int i, List<Integer> curr, int total) {

        if (total == target) {
            res.add(List.copyOf(curr));
            return;
        }
        
        if (i >= size || total > target)
            return;
        
        curr.add(nums[i]);
        dfs(i, curr, total + nums[i]);
        curr.remove(curr.size() - 1);
        dfs(i+1, curr, total);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.size = nums.length;
        this.target = target;
        this.nums = nums;
        dfs(0, new ArrayList<>(), 0);
        return res;
    }
}
