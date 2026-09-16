class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] sChar = s.toCharArray();
        int ret = 0;
        int l = 0;
        int r = l;
        Set<Character> set = new HashSet<>();

        int curr = 0;
        while (r < s.length()) {
            if (set.contains(sChar[r])) {
                ret = Math.max(ret, r - l);
                set.remove(sChar[r]);
                if (sChar[r] == sChar[l]) {
                    l++;
                } else {  // find where the duplicate lives
                    while (sChar[r] != sChar[l]) {
                        set.remove(sChar[l]);
                        l++;
                    }
                    l++;  // remove the duplicate
                }
            } else {
                set.add(sChar[r]);
                r++;
            }
        }
        ret = Math.max(ret, r-l);
        return ret;
    }
}
