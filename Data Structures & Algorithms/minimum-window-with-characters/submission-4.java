class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            have.put(c, 0);
        }

        int haveCounter = 0, needCounter = need.keySet().size();
        int start = 0, end = 0;
        int resBegin = 0, resEnd = 0, resLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            Character cur = s.charAt(end);

            if (have.containsKey(cur))
                have.put(cur, have.get(cur) + 1);

            if (have.containsKey(cur) && have.get(cur) == need.get(cur)) {
                haveCounter++;
            }

            System.out.println(haveCounter + " " + needCounter);
            while (haveCounter == needCounter) {
      
                
                int size = end - start + 1;
                if (size < resLength) {
                    resBegin = start;
                    resEnd = end;
                    resLength = size;
                }

                Character charAtStart = s.charAt(start);
                if (have.containsKey(charAtStart)){
                    have.put(charAtStart, have.get(charAtStart) - 1);
                    if (need.keySet().contains(charAtStart) && have.get(charAtStart) < need.get(charAtStart)) {
                        haveCounter--;
                    }
                }
                start++;
                
            }
            end++;
        }

        return resLength == Integer.MAX_VALUE ?  "" : s.substring(resBegin, resEnd+1);
    }
}
