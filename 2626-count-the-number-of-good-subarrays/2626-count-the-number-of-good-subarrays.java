class Solution {
    public long countGood(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long countPairs = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            int currFreq = freq.getOrDefault(num, 0);
            countPairs += currFreq;
            freq.put(num, currFreq + 1);

            while (countPairs >= k) {
                result += nums.length - right;  // all subarrays from left to right are good
                int leftNum = nums[left];
                int leftFreq = freq.get(leftNum);
                countPairs -= (leftFreq - 1);
                freq.put(leftNum, leftFreq - 1);
                left++;
            }
        }

        return result;
    }
}

        
   