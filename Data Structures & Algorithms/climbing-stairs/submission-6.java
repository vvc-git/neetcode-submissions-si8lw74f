class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int[] possibility = new int[n+1];
        possibility[1] = 1;
        possibility[2] = 2;
        for (int i = 3; i <= n; i++) {
            possibility[i] = possibility[i-1] + possibility[i-2];
        }
        return possibility[n];
    }
}
