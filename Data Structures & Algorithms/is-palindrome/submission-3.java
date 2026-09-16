class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] sChar = s.toLowerCase().toCharArray();

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(sChar[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(sChar[r])) {
                r--;
            }

            if (sChar[l] != sChar[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
