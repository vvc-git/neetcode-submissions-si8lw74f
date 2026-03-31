class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> frequency = new HashMap<>();
        int left = 0;
        int size = s.length();
        int longest = 1;

        for (int right = 0; right < size; right++) {
            Character key = s.charAt(right);
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            System.out.printf("Adicionando %s, Map: %s \n", key, frequency.values());

            if ((right - left + 1) - Collections.max(frequency.values()) > k) {
                 key = s.charAt(left);
                frequency.put(key, frequency.get(key) - 1);
                System.out.printf("Removendo %s, Map: %s \n", key, frequency.values());
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            System.out.printf("longest %s, Map: %s \n", longest, frequency.values());
        }
        return longest;

    }
}
