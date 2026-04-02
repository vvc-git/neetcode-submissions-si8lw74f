class Solution {

    public int numberOf1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }


    public int[] countBits(int n) {
        int[] res = new int[n+1];
        
        for (int i = 0; i <= n; i++) {
            res[i] = numberOf1(i);
        }
        return res;
    }
}
