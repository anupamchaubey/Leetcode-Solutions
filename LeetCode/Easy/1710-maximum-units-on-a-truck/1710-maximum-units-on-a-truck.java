class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)-> b[1]-a[1]);
        
        int maxUnits=0;
        int l=0;
        while(l<boxTypes.length && truckSize>0){
            int units=boxTypes[l][1];
            int boxes=boxTypes[l][0];
            l++;
            boxes=Math.min(boxes, truckSize);
            maxUnits+=(boxes*units);
            truckSize-=boxes;
        }
        return maxUnits;
    }
}