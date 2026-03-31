class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> frequency = new HashMap<>();
        int left = 0;
        int size = s.length();
        int result = 1;

        for (int right = 0; right < size; right++) {
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);
            while ((right - left + 1) - Collections.max(frequency.values()) > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1); 
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
