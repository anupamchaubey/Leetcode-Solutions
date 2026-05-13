class Solution {
    int target;
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int t) {
        target = t;
        rec(num, 0, "");
        return ans;
    }

    void rec(String num, int idx, String s) {
        if (idx == num.length()) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }

        String str = "";
        for (int i = idx; i < num.length(); i++) {
            if (i > idx && num.charAt(idx) == '0')
                break;
            str += num.charAt(i);
            if (idx == 0) {
                rec(num, i + 1, s + str);
            } else {
                rec(num, i + 1, s + "*" + str);
                rec(num, i + 1, s + "+" + str);
                rec(num, i + 1, s + "-" + str);
            }
        }
    }

    boolean isValid(String s) {
        Stack<Long> st = new Stack<>();

        long num = 0;
        char op = '+';

        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            if(!Character.isDigit(ch) || i == s.length() - 1) {
                if (op == '+')
                    st.push(num);
                else if (op == '-')
                    st.push(-num);
                else {
                    if(st.isEmpty())return false;
                    long last = st.pop();
                    st.push(last * num);
                }
                op=ch;
                num = 0;
            }
        }

        long sum = 0;

        for (long val : st) {
            sum += val;
        }

        return sum == target;
    }
}