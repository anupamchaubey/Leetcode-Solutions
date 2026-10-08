class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (depth > 0)
                    sb.append('(');
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    sb.append(')');
                }
            }
        }

        return sb.toString();
    }
}