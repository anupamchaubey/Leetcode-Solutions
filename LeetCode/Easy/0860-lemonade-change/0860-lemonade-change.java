class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0, tewnty=0;
        for(int x: bills){
            if(x==5)five++;
            else if(x==10){
                if(five<1)return false;
                five--;
                ten++;
            }else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>2){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}