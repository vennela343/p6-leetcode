class Solution {

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String rev = new String(arr);

        String combined = s + "#" + rev;

        int[] lps = computeLPSArray(combined);

        int charsToAdd = n - lps[combined.length() - 1];
        return rev.substring(0, charsToAdd) + s;
    }

    private int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
