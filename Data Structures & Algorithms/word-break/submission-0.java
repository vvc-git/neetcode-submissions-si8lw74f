class Solution {
    String s;
    Set<String> wordDict = new HashSet<>();

    public boolean dfs(int begin) {
        if (begin == s.length()) {
            return true;
        }

        for (int end = begin + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(begin, end))) {
                if (dfs(end)) {
                    return true;
                }
            }
        }

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
