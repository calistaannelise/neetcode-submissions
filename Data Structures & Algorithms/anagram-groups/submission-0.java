class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] arr = new int[26];
            char[] sChar = s.toCharArray();
            for (char c : sChar) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            map.put(key, map.getOrDefault(key, new ArrayList<>()));
            List<String> l = map.get(key);
            l.add(s);
        }

        for (String a : map.keySet()) {
            ret.add(map.get(a));
        }
        return ret;
    }
}
