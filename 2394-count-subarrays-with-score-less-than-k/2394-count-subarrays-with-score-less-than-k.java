class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left=0;
        long count=0;
        long currSum=0;
        for(int right=0;right<nums.length;right++){
            currSum += nums[right];
            while(currSum*(right-left+1)>=k){
                currSum-=nums[left];
                left++;
            }
            count +=right-left+1;
        }
        return count;
    }
}