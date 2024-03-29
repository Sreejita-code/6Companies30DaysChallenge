package Walmart;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int f=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            f=f+(nums[i]*i);
            sum=sum+nums[i];
        }
        int max=f;
        int n=nums.length;
        for(int i=n-1;i>=1;i--){
            f=f+sum-n*nums[i];
            max=Math.max(max,f);
        }
        return max;
    }
}
