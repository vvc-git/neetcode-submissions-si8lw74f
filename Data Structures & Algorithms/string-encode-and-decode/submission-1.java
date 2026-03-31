class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
    
        for (String s : strs) {
            sb.append(s);
            sb.append("-");
        }
        // System.out.printf("%s", sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            // System.out.printf("%s", c);
            if (c == '-') {
                res.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
            System.out.printf("%s\n", sb.toString());
        }
        System.out.printf("%s\n", res);
        return res;
    }
}
