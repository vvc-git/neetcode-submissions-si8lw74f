class Solution {
    public int[] twoSum(int[] nums, int target) {

        // We assume that every input has exactly one pair of indices i and j that satisfy
        // the condition. So we only have to numbers in result array
        int[] result = new int[2];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[idx] = i;
                    result[idx + 1] = j;
                    idx = idx + 2;
                }
            }
        }

        return result;

    }
}
