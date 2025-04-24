class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while(!stack.isEmpty()  && num > stack.peek()) {
                int smallerNum = stack.pop();
                nextGreaterMap.put(smallerNum, num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++){
            result[i]=nextGreaterMap.get(nums1[i]);
        }
        return result;
        
    }
}