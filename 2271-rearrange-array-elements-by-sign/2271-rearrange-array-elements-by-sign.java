class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int even=0;
        int odd=1;
        int[] result=new int[n];
        for(int a:nums){
            if(a>0){
                result[even]=a;
                even = even+2;

            }else{
                result[odd]=a;
                odd=odd+2;
            }
        }
        return result;
    }
}