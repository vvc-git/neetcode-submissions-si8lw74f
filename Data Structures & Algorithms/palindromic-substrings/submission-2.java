class Solution {

    public int countPalindrome(String s, int left, int right) {
        int res = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            res++;
        }
        return res;
    }


    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // Considering as odd-length
            res += countPalindrome(s, i, i);
            // Considering as even-length
            res += countPalindrome(s, i, i+1);
        }
        return res;

    }
}
