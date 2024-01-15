package Walmart;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int j=0;
        int ans=0;
        int maxi=0;
        for(int i=0;i<s.length();i++){
            ans+=Math.abs((int)s.charAt(i)-(int)t.charAt(i));
            if(ans<=maxCost){
                maxi=Math.max(maxi,i-j+1);
            }
            else{
                while(ans>maxCost){
                    ans-=Math.abs((int)s.charAt(j)-(int)t.charAt(j));
                    j++;
                }
            }
        }
        return maxi;
    }
}
