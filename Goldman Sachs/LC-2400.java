class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int modu=1000000007;
        int[][] dp=new int[3002][k+1];
        dp[startPos+1000][k]=1;
        for(int j=k-1;j>=0;j--){
            for(int ind=1;ind<=3000;ind++){
                dp[ind][j]=((dp[ind][j]+dp[ind-1][j+1])%modu+dp[ind+1][j+1])%modu;
            }
        }
        return dp[endPos+1000][0];
    }
}
