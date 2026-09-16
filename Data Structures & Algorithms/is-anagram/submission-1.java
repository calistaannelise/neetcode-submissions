class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (char c : sChar) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
