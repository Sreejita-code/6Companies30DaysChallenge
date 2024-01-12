package Microsoft;

import java.util.Arrays;

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int len=nums.length;
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int subArray[]=Arrays.copyOfRange(nums,i,j+1);
                if(isTrue(addArrays(Arrays.copyOfRange(nums,0,i),Arrays.copyOfRange(nums,j+1,len))) && subArray.length>0){
                    count++;
                }
            }
        }
        return count;      
    }
    public static boolean isTrue(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static int[] addArrays(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int[] result=new int[n1+n2];
        System.arraycopy(arr1,0,result,0,n1);
        System.arraycopy(arr2,0,result,n1,n2);
        return result;
    }
}
