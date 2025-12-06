class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int n = nums.length;
        int threshold = n / 3;
        int count = 1;  

        for (int i = 1; i <= n; i++) {

            if (i < n && nums[i] == nums[i - 1]) {
                count++;
            }
            else {
                
                if (count > threshold) {
                    result.add(nums[i - 1]);
                }
                count = 1; 
            }
        }

        return result;
    }
}
