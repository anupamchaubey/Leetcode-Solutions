class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] arr=new int[128];
        for(int i=0;i<t.length();i++){
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for(int i:arr){
            if(i!=0)return false;
        }
        return true;
    }
}