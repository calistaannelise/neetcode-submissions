class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        return false;
    }
}
