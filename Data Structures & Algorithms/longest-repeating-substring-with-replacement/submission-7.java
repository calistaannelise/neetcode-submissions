class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> chars = new HashSet<>();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        for (char c : chars) {
            int change = 0;
            int l = 0;
            int r = l;
            while (l <= r && r < s.length()) {
                if (s.charAt(r) != c) {
                    if (change == k) {
                        while (l <= r && s.charAt(l) == c) {
                            l++;
                        }
                        l++;
                    } else {
                        change++;
                    }
                }
                r++;
                ret = Math.max(r-l, ret);
            }
        }
        return ret;
    }
}
