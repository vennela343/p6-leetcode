class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>>Map=new HashMap<>();
    for(String str: strs) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedstr = new String(charArray);
        Map.putIfAbsent(sortedstr, new ArrayList<>());
        Map.get(sortedstr).add(str);
    }
    return new ArrayList<>(Map.values());
    

        
    }
}