class Solution {
    public int findMin(int[] nums) {
        
        int result = nums[0];
        for (int num : nums) {
            result = Math.min(result, num);
        }

        return result;
    }
}
