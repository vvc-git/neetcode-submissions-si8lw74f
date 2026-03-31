class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[][] mtx = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            mtx[i][0] = nums[i];
            mtx[i][1] = i;
        }
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(mtx, Comparator.comparingInt(a -> a[0]));
        
        while (left < right) {
            int sum = mtx[left][0] + mtx[right][0];
            if (target == sum) {
                return new int[]{Math.min(mtx[left][1], mtx[right][1]), Math.max(mtx[left][1], mtx[right][1])};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return new int[2];
    }
}
