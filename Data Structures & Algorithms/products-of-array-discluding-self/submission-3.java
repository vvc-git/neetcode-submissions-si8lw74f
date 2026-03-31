class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] result = new int[size];
        result[0] = 1;
        int previousProduct = nums[0];

        for (int i = 1; i < size; i++) {
            result[i] = previousProduct;
            previousProduct = nums[i] * previousProduct;
        }
        
        previousProduct = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = previousProduct * result[i];
            previousProduct = nums[i] * previousProduct;
        } 
        return result;

    }
}  
