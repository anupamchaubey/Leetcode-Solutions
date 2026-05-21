class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans=0;
        StringBuilder sb=new StringBuilder();
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            sb.append(arr1[i]);
            for(int j=1;j<=sb.length();j++){
                hs.add(sb.substring(0, j));
            }
            sb.setLength(0);
        }
        
        for(int i=0;i<arr2.length;i++){
            sb.append(arr2[i]);
            for(int j=1;j<=sb.length();j++){
                if(hs.contains(sb.substring(0, j))){
                    ans=Math.max(ans, j);
                }
            }
            sb.setLength(0);
        }
        return ans;
    }
}