class Solution {
    public boolean isAnagram(String s, String t) {


        Map<Character, Integer> seen = new HashMap<>();
        char[] sAsChar = s.toCharArray();
        char[] tAsChar = t.toCharArray();

        if (sAsChar.length != tAsChar.length) {
            return false;
        } 

        for (char c : sAsChar) {
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }

        for (char c : tAsChar) {
            if (seen.containsKey(c)) {
                Integer temp = seen.get(c);
                if (temp - 1 < 0) {
                    return false;
                } else {
                    seen.put(c, temp - 1);
                }
            } else {
                return false;
            }

        }

        return true;
    }
}
