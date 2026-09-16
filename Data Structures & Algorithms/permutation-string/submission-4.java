class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int [] tar = new int [26];
        int n = s1.length();
        char [] sp = s2.toCharArray();

        for(char s:s1.toCharArray()){
            tar[s-'a']++;
        }
        for(int i = 0;i<s1.length();i++){
            if(--tar[sp[i]-'a']>=0){
                n--;
            }
            if(n==0)return true;
        }
        for(int i = s1.length();i<sp.length;i++){
            int head = ++tar[sp[i - s1.length()]-'a'];
           int tail =  --tar[sp[i]-'a'];
            if(head>0){
                n++;
            }
            if(tail>=0){
                n--;
            }
            if(n==0)return true;


        }
        return false;

    }
}
