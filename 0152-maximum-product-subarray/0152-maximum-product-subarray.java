class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct=nums[0];
        int minProduct=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxProduct;
                maxProduct=minProduct;
                minProduct=temp;
            }
                maxProduct=Math.max(nums[i],nums[i]*maxProduct);
                minProduct=Math.min(nums[i],nums[i]*minProduct);
                result=Math.max(result,maxProduct);

            
        }
        return result;
    }
}