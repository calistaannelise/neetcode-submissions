class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        int l = 0;
        int ret = 0;
        int maxC = 0;

        for (int r = 0; r < s.length(); r++) {
            map.put(sChar[r], map.getOrDefault(sChar[r], 0) + 1);
            maxC = Math.max(maxC, map.get(sChar[r]));
            if ((r-l+1) - maxC > k) {
                map.put(sChar[l], map.get(sChar[l]) - 1);
                l++;
            }
            ret = Math.max(ret, (r-l+1));
        }
        return ret;
    }
}
