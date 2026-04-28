class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        if (t.length() == 1 && s.length() == 1 && t.charAt(0) == s.charAt(0)) return t.substring(0, 1);
        int left = 0, right = 0;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        int leftRes = 0, rightRes = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            have.put(c, 0);
        }
        int needCounter = need.keySet().size(), haveCounter = 0;

        while (right < s.length()) {
            Character curr = s.charAt(right);

            if (have.containsKey(curr)) {
                have.put(curr, have.get(curr) + 1);
            }

            if (have.containsKey(curr) && have.get(curr).equals(need.get(curr))) {
                haveCounter++;
            }

            // valid solution
            while (needCounter == haveCounter) {
                int curLength = right - left + 1;

                if (curLength < minimumLength) {
                    leftRes = left;
                    rightRes = right;
                    minimumLength = curLength;
                }
                Character leftMost = s.charAt(left);

                if (have.containsKey(leftMost))
                    have.put(leftMost, have.get(leftMost) - 1);
                if (have.containsKey(leftMost) && have.get(leftMost) < need.get(leftMost)) {
                    haveCounter--;
                }
                left++;
            }
            right++;
        }
        return minimumLength == Integer.MAX_VALUE ? "" : s.substring(leftRes, rightRes+1);
    }
}
