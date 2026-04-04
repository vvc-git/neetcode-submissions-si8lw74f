class Solution {


    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // Fill the diagonal
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (cl == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                    if (dp[i][j] && cl > maxLen) {
                        start = i;
                        maxLen = cl;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
