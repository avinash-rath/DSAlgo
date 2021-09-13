package leetcode.java;

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;

class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        int[] balloon = new int[26];
        
        String bal = "balloon";
        
        
        // freq in balloons
        for(Character c : bal.toCharArray()) {
            balloon[c - 'a']++;
        }
        
        // freq in text
        for(Character c : text.toCharArray()) {
            hash[c-'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        // compare
        for(int i = 0; i < 26; i++) {
            if(balloon[i] == 0) continue;
            min = Math.min(hash[i]/balloon[i], min);
        }
        return min;
    }
    // works but slow. meh!
    // public int maxNumberOfBalloons(String text) {
    //     HashMap<Character, Integer> freq = new HashMap<>();
    //     Set<Character> charSet = new HashSet<>(Arrays.asList(new Character [] {'b','a','l','o','n'}));
    //     for(char c : text.toCharArray()) {
    //         if(charSet.contains(c))
    //         freq.merge(c,1,Integer::sum);
    //     }
    //     for(Character c : charSet) {
    //         int n = freq.getOrDefault(c,0);
    //         if(c == 'l' || c =='o') n /= 2;
    //         freq.put(c,n);
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(Integer i : freq.values()) {
    //         min = Math.min(min, i);
    //     }
    //     return min;
    // }
}