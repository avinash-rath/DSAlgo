package placements.optum.java;

class LongestPalindrome{
    public String longestPalindrome(String string) {
        int start=0, end=0;
        for(int i=0;i < string.length() -1; i++) {
            int len = Math.max(expand(string,i,i), expand(string, i, i+1));
            if((end - start) < len){
                start  = i - ((len-1)/2);
                end = i + len/2;
            }
        }
        return string.substring(start,end+1);
    }

    private int expand(String string, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < string.length() && string.charAt(L) == string.charAt(R)) {
            L--; R++;
        }
        return R - L - 1;
    }
}

/*
    aaaababa

*/