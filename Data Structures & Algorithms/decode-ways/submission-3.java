class Solution {
    int size = 0;
    Map<Integer, Integer> cache = new HashMap<>();

    // How many ways can I decode the substring starting at index i
    public int dfs(String s, int i) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        if (i == size) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0; // invalid
        }

        int oneDigit = dfs(s, i + 1);
        int twoDigit = 0;
        if (i + 1 < size && Integer.valueOf(s.substring(i, i + 2)) <= 26) {
            twoDigit = dfs(s, i + 2);
        } 
        cache.put(i, oneDigit+twoDigit);
        return oneDigit + twoDigit;

    }


    public int numDecodings(String s) {
        size = s.length();
        return dfs(s, 0);
    }
}
