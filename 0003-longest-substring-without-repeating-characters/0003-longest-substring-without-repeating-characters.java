class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0;
        int currLen=0,maxLen=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
                currLen--;
            }
            set.add(s.charAt(right));
            currLen++;
            maxLen=Math.max(maxLen,currLen);
        }
        return maxLen;
        
    }
}