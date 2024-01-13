package Walmart;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int temp[] = new int[nums.length];
        for (int i =0 ;i<nums.length;i++){ temp[i]=nums[i];}
        int res[] = new int[k];
        Arrays.sort(temp);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = temp.length - 1; i>=nums.length-k ; i--) {
            if (hm.containsKey(temp[i])) {
                hm.put(temp[i], hm.get(temp[i]) + 1);
            } else {
                hm.put(temp[i], 1);
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == k) {
                break;
            }
            if (hm.containsKey(nums[i])) {
                if (hm.get(nums[i]) == 1) {
                    hm.remove(nums[i]);
                } else {
                    hm.put(nums[i], hm.get(nums[i]) - 1);
                }
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }
}
