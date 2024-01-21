package Adobe;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
       int leftposi=Integer.MIN_VALUE;
       int rightposi=Integer.MAX_VALUE;
       for(int i=0;i<left.length;i++){
           if(leftposi<left[i]){
               leftposi=left[i];
           }
       } 
        for(int i=0;i<right.length;i++){
            if(rightposi>right[i]){
                rightposi=right[i];
            }
        }
        return Math.max(leftposi,n-rightposi);
    }
}
