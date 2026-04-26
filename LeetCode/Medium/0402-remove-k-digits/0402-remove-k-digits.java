class Solution {
    public String removeKdigits(String num, int k) {

        //To make a number smaller, you want the digits to be in non-decreasing order (like 1234). If you see a "cliff"—where a digit is followed by a smaller digit (like 4 followed by 3 in 143)—you should remove the larger digit to make the overall number smaller.

        if (num.charAt(0) == '0')
            return "0";

        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            if (st.isEmpty() || st.peek() <= num.charAt(i) - '0') {
                st.push(num.charAt(i) - '0');
            } else {
                while (!st.isEmpty() && st.peek() > num.charAt(i) - '0' && k > 0) {
                    st.pop();
                    k--;
                }
                st.push(num.charAt(i) - '0');
            }
            i++;
        }
        while (k-- > 0) {
            st.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        

        int p = 0;
        while (p<sb.length() && sb.charAt(p) == '0')
            p++;

        if (sb.toString().substring(p).equals(""))
            return "0";
        
        return sb.toString().substring(p);
    }
}