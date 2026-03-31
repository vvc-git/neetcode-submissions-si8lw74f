class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] result = new int[size];
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int previousProduct = nums[0];
        prefix[0] = 1;
        suffix[size-1] = 1;

        for (int i = 1; i < size; i++) {
            prefix[i] = previousProduct;
            previousProduct = nums[i] * previousProduct;
        }
        
        previousProduct = 1;
        for (int i = size - 1; i >= 0; i--) {
            suffix[i] = previousProduct;
            previousProduct = nums[i] * previousProduct;
        } 

        for (int i = 0; i < size; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        System.out.printf("prefix: %s\nsuffix: %s\nresult: %s", Arrays.toString(prefix), Arrays.toString(suffix), Arrays.toString(result));
        return result;

    }
}  
