class Solution {
    public boolean isPalindrome(String s) {

        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int begin = 0;
        int end = clean.length() - 1;

        while (begin < clean.length() && end >= 0) {
            if (clean.charAt(begin) != clean.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
