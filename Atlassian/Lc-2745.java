class Solution {
    public int longestString(int x, int y, int z) {
       int a=2*Math.min(x,y);
       if(x!=y){
           a++;
       } 
       return 2*(a+z);
    }
}
