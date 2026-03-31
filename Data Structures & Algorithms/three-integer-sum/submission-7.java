class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int size = nums.length;

    for (int i = 0; i < size; i++) {
        // Example: if nums[i] = 1, we dont have a value (such as -1) in the right
        // of i such will be posible to get 0.
        // if (nums[i] > 0) break;
        // always 
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int j = i + 1;
        int k = size - 1;
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                List<Integer> partial = new ArrayList<>(3);
                partial.add(nums[i]);
                partial.add(nums[j]);
                partial.add(nums[k]);
                j++;
                k--;
                result.add(partial);
                // avoids duplicates?
                while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                }
            } else if (sum < 0) {
                j++;
            } else {  // sum > 0 
                k--;
            }
        }
    }
    return result;
    }
}
