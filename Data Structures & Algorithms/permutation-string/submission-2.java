class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (char c : s1.toCharArray()) {
            arr[c - 'a']++;
        }

        int[] arrS2 = new int[26];
        int l = 0;
        int r = s1.length() - 1;
        char[] sChar = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            arrS2[sChar[i] - 'a']++;
        }

        while (r < s2.length()) {
            if (Arrays.equals(arr, arrS2)) {
                return true;
            }
            if (r + 1 >= s2.length()) {
                return false;
            }
            arrS2[sChar[l] - 'a']--;
            l++;
            r++;
            arrS2[sChar[r] - 'a']++;
        }
        return false;
    }
}
