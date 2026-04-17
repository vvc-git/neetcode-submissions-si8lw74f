class Solution {
    public int missingNumber(int[] nums) {
        int xorOfAllNumbers = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("i: " + Integer.toBinaryString(i));
            xorOfAllNumbers = i ^ xorOfAllNumbers;
        }
        

        int xorOfNums = nums.length;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i] " + Integer.toBinaryString(nums[i]));
            xorOfNums = xorOfNums ^ nums[i];
            
        }
        System.out.println("xorOfAllNumbers: " + Integer.toBinaryString(xorOfAllNumbers));
        System.out.println("xorOfNums: " + Integer.toBinaryString(xorOfNums));

        return xorOfAllNumbers ^ xorOfNums;
    }
}
