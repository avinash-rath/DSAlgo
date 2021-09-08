package leetcode.java;

public class ShiftingLetters {
    //fast boi
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        char [] ret = new char[shifts.length];
        for(int i = 0; i < s.length(); i++) {
            ret[i] = (char)((s.charAt(i) + shifts[i] - 'a') % 26 + 'a');
        }
        return new String(ret);
    }
    /*
    // more memory optimized in terms of using a char Array
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            b.append((char)((s.charAt(i) + shifts[i] - 'a') % 26 + 'a'));
        }
        return b.toString();
    }
    */
    
    /*
    // slow and unoptimized solution
    public String shiftingLetters(String s, int[] shifts) {
        int [] changes = new int[s.length()];
        changes[changes.length-1] = shifts[changes.length-1] % 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            changes[i] = (shifts[i] + changes[i+1]) % 26;
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i); int a = 'a'; int z = 'z';
            num += changes[i];
            if(num > z) num = num - z + a-1;
            builder.append((char)num);
        }
        return builder.toString();
    }
    */
}
