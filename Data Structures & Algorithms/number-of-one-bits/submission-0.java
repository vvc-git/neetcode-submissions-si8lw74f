class Solution {
    public int hammingWeight(int n) {

        String stringRep = Integer.toBinaryString(n);
        System.out.println(stringRep);
        int count = 0;
        for (char c : stringRep.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count;
        
    }
}
