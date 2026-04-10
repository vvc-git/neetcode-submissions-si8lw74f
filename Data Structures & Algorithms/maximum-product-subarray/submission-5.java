class Solution {
    public int maxProduct(int[] nums) {

        Map<String, Integer> products = new HashMap<>();
        int maxProduct = 1;
        int minProduct = 1;
        int res = nums[0];

        for (int num : nums) {
            int temp = maxProduct * num;
            maxProduct = Math.max(Math.max(num * maxProduct, num * minProduct), num);
            minProduct = Math.min(Math.min(temp, num * minProduct), num);
            res = Math.max(maxProduct, res);
        }
        return res;

    }
}
