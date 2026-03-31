class Solution {
    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                System.out.printf("%s", c);
            } else {
                if (stack.isEmpty()) return false;

                if  ((c == ')' &&  stack.peek() == '(') ||  
                    (c == ']' &&  stack.peek() == '[') ||
                    (c == '}' &&  stack.peek() == '{')) {
                        stack.pop();
                        continue;
                    }
                if  ((c == ')' &&  stack.peek() != '(') ||  
                    (c == ']' &&  stack.peek() != '[') ||
                    (c == '}' &&  stack.peek() != '{')) {
                        return false;
                    }

            }
        }
        return stack.isEmpty();
    }
}
