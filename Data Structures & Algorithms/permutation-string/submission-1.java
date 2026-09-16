class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for (char c : s1.toCharArray()) {
            arr[c - 'a']++;
        }

        char[] sChar = s2.toCharArray();
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (arr[sChar[i] - 'a'] != 0) {
                for (int j = i; j < i + s1.length(); j++) {
                    arr[sChar[j] - 'a']--;
                }
                if (Arrays.equals(arr, new int[26])) {
                    return true;
                }
                // return the array to the original
                for (int j = i; j < i + s1.length(); j++) {
                    arr[sChar[j] - 'a']++;
                }
            }
        }
        return false;
    }
}
