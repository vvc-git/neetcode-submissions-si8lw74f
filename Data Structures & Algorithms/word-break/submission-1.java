class Solution {
    String s;
    Set<String> wordDict = new HashSet<>();
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean dfs(int begin) {
        if (begin == s.length()) return true;

        if (memo.containsKey(begin)) return memo.get(begin);

        for (int end = begin + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(begin, end)) && dfs(end)) {
                memo.put(begin, true);
                return true;
            }
        }

        memo.put(begin, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;

        for (String word : wordDict) {
            this.wordDict.add(word);
        }
        
        return dfs(0);
    }
}
