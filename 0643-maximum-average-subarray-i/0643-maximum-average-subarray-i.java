class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int currSum=0;
        for(int i=0;i<k;i++){
            currSum += nums[i];
        }
        double maxSum=currSum;
        for(int right=k;right<nums.length;right++){
            currSum -=nums[left];
            currSum +=nums[right];
            maxSum=Math.max(maxSum,currSum);
            left++;
            
        }
        return maxSum/k;

    }
}