class Solution {
    public int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            // Pick the bit
            int bit = (n >> i) & 1;
            System.out.println(Integer.toBinaryString(bit));
            // Move bit to new position
            res |= bit << (31 - i);
            // System.out.println(Integer.toBinaryString(res));
        }
        return res;
        
    }
}
