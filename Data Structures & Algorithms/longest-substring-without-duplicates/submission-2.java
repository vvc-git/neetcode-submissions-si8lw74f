class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = -1, right = 0;
        int size = s.length();
        int longest = 0;
        List<Character> substring = new ArrayList<>();
        
        while (right < size) {
            // System.out.printf("Adding: %s\n", substring.toString());
            while (left < size && substring.contains(s.charAt(right))) {
                left++;
                substring.remove(0);
                //System.out.printf("Removing %s\n", substring.toString());
            }
            substring.add(s.charAt(right));
            longest = Math.max(longest, right - left);
            right++;
        }
        return longest;

        
    }
}
