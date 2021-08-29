package leetcode.java;

class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        
        String check = "", numString = Integer.toString(N);
        int start = 0, len = numString.length();
        int [] nums = new int[10], checknums = new int[10];
        int i;
        
        //create a hashmap
        for(char j: numString.toCharArray()) nums[j - '0']++;
        
        checknums = nums.clone();
        
        while(start < 30) { // log2(10^9)
            check = Integer.toString((int)Math.pow(2,start));
            if(check.length() == len) {
                for(i = 0; i < len; i++) {
                    if(checknums[check.charAt(i) - '0'] > 0) {
                        checknums[check.charAt(i) - '0']--;
                    } else {
                        checknums = nums.clone();
                        break;
                    }
                }
                if(i == len) return true;
            } else if (check.length() > len) break;
            start++;
        }
        return false;
    }
}
