class Solution {
    public String minWindow(String s, String t) {
    if (t.length() > s.length()) return "";

    Map<Character, Integer> sFreq = new HashMap<>();
    Map<Character, Integer> tFreq = new HashMap<>();

    for (Character c : t.toCharArray()) {
        tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
    }

    int begin = 0, end = 0;
    int sCounter = 0, tCounter = tFreq.keySet().size();
    int beginRes = 0, endRes =0;
    int lengthRes = Integer.MAX_VALUE;

    while (end < s.length()) {
        
        Character curr = s.charAt(end);
        sFreq.put(curr, sFreq.getOrDefault(curr, 0) + 1);

        if (tFreq.containsKey(curr) && sFreq.get(curr).equals(tFreq.get(curr))) {
            sCounter++;
        }

        while (sCounter == tCounter) {
            int currLength = (end - begin + 1);
            if (currLength < lengthRes) {
                beginRes = begin;
                endRes = end;
                lengthRes = currLength;
            }

            Character leftMost = s.charAt(begin);
            sFreq.put(leftMost, sFreq.get(leftMost) - 1);
            if (tFreq.containsKey(leftMost) && sFreq.get(leftMost) < tFreq.get(leftMost)) {
                sCounter--;
            }
            begin++;
        }
        end++;
    }

    return lengthRes != Integer.MAX_VALUE ? s.substring(beginRes, endRes+1) : "";    
    }
}
