class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] frequency = new int[26];
            Arrays.fill(frequency, 0);

            for (char c : str.toCharArray()) {
                frequency[c - 'a']  += 1; 
            }
            String key = Arrays.toString(frequency);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
