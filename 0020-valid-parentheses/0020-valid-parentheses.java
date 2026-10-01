class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty() || !isValid(st, ch))
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    boolean isValid(Stack st, Character ch) {
        if (st.peek().equals('(') && ch == ')')
            return true;
        if (st.peek().equals('[') && ch == ']')
            return true;
        if (st.peek().equals('{') && ch == '}')
            return true;
        return false;
    }
}