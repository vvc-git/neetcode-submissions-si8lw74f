class Solution {
    public int climbStairs(int n) {

        int[] possibility = new int[n];
        possibility[0] = 1;

        if (n < 2)
            return possibility[n-1];

        possibility[1] = 2;
        for (int i = 2; i < n; i++) {
            possibility[i] = possibility[i-1] + possibility[i-2];
        }
        return possibility[n-1];
    }
}
