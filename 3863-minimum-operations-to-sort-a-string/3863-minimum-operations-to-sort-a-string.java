class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        if (s.equals(sorted))
            return 0;
        if (s.length() == 2)
            return -1;
        if (s.charAt(0) == sorted.charAt(0) || s.charAt(arr.length - 1) == sorted.charAt(arr.length - 1))
            return 1;
        if ((sorted.charAt(0) != sorted.charAt(1) && s.charAt(0) == sorted.charAt(arr.length - 1))
                && (s.charAt(arr.length - 1) == sorted.charAt(0)
                        && sorted.charAt(arr.length - 1) != sorted.charAt(arr.length - 2)))
            return 3;
        return 2;

    }
}