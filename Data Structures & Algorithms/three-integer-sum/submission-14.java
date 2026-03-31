class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // System.out.printf("Novo array:%s\n", Arrays.toString(nums));
        
        for (int i = 0; i < nums.length; i++) {
            // System.out.print("atualizando o target\n");
            int target = nums[i];
            int begin = i + 1;
            int end = nums.length - 1;

            while (begin < end) {
                //System.out.printf("target: %s, begin: %s, end: %s\n", target, nums[begin], nums[end]);
                if (target + nums[begin] + nums[end] > 0) {
                    end--;
                } else if (target + nums[begin] + nums[end] < 0) {
                    begin++;
                } else {
                    // Because target <= nums[begin] <= num[end]
                    if (!result.contains(Arrays.asList(target, nums[begin], nums[end])))
                        result.add(Arrays.asList(target, nums[begin], nums[end]));
                    // System.out.printf("result:%s\n", result);
                    begin++;
                    end--;
                }
            }
        }
        
        return result;
    }
}
