package amazon;

import java.util.*;

public class NutsAndBolts {
    static int numChars;
    static char [] a;
    public char [] solve(char [] nuts, char [] bolts, int n) {
        char [] ans = new char [nuts.length];
        Map<Character, Integer> map = new TreeMap<>();
        int count=0;
        for(char i : nuts) {
            map.merge(i,1,Integer::sum);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            int temp;
            temp = entry.getValue();
            while(temp-->0) {
                ans[count] = entry.getKey();
                count++;
            }
        }
        return ans;
    }

    public static void main(String...s) {
        a = new char [] {'!','#','$','%','&','*','@','^','~'};
        numChars = a.length;
        String nuts = "^&%@#*$~!",bolts="~#@%&*$^!";
        NutsAndBolts test = new NutsAndBolts();
        for(char i : test.solve(nuts.toCharArray(), bolts.toCharArray(), nuts.length())) System.out.print(i+" ");
        
    }

}



// []
