class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum >= target) {
                int currLen = right - left + 1;   
                minLen = Math.min(minLen, currLen);
                currSum -= nums[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
