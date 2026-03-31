class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    result[j] = nums[i] * result[j]; 
                }

            }
        }

        return result;
    }
}  
