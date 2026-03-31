class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        int[] newNums = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {

            System.out.print("i: " + i + " ");

            for (int j = 0; j < i; j++) {
                System.out.print("j: " + newNums[j] + " ");
                if (nums[i] == newNums[j]) {
                    return true;
                }

            }
            newNums[i] = nums[i];
            
        }

        return false;
    }
}
