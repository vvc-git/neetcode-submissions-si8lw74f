class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            int[] arr = new int[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a'] = arr[c - 'a'] + 1; // it will throw an error because it could be empty
                System.out.printf("%s, value: %s\n", c, arr[c - 'a']);
            }

            String key = Arrays.toString(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str); 
        }

        return new ArrayList<>(map.values());
    }
}
