class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Set<Character> uniques = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uniques.add(s.charAt(i));
        }

        for (Character caractere : uniques) {
            int countS = 0;
            int countT = 0;
            for (int i = 0; i < s.length(); i++) {
               if (s.charAt(i) == caractere) {
                    countS++;
               }
                if (t.charAt(i) == caractere) {
                    countT++;
               }
            }

            if (countS != countT) {
                return false;
            }

        }
        return true;

    }
}
