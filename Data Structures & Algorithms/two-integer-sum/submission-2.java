class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> diffToTarget = new HashMap<>();
        int [] result = new int[2];        
        for (int i = 0; i < nums.length; i++) {

            // Check if the difference is key of our hashmap
                // if true, we will add to result
                if (diffToTarget.containsKey(target - nums[i])) {
                    result[0] = diffToTarget.get(target - nums[i]);
                    result[1] = i;
                } else {
                    diffToTarget.put(nums[i], i);
                }// if it is false, so we add to diffToTarge

        }

        return result;
    }
}
