class Solution {
    public int maxVowels(String s, int k) {
        String vowels="aeiou";
        int left=0,count=0;
        for(int i=0;i<k;i++){
            if(vowels.contains(String.valueOf(s.charAt(i)))){
                count++;   
            }
        }
        int max=count;
        for(int right=k;right<s.length();right++){
            if(vowels.contains(String.valueOf(s.charAt(left)))){
                count--;
            }
            if(vowels.contains(String.valueOf(s.charAt(right)))){
                count++;
            }
            left++;
            max=Math.max(max,count);
        }
        return max;
    }
}