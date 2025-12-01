class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total=0;
        for(int element:arr){
            total +=element;
        }
        if(total % 3!=0) return false;
        int target=total/3;
        int currSum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum==target){
                count++;
                currSum=0;
                if(count==2 && i<arr.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}