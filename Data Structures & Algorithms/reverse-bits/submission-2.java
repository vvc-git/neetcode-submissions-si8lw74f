class Solution {
    public int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            // Pick the bit
            int bit = (n >> i) & 1;
            // Move bit to new position
            res |= bit << (31 - i);        }
        return res;
        
    }
}
