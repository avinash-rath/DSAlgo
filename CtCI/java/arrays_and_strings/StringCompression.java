package CtCI.java.arrays_and_strings;

/**
 * 1.6 Implement a method to perform basic string compression using the counts
 * of repeated characters. For instance, the string aabcccccaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters(a-z).
 */

public class StringCompression {
    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1, l = s.length();
        for(int i = 1; i<l; i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
            else count++;
            if(i==l-1) { // not really optimal due to this comarison
                sb.append(s.charAt(i));
                sb.append(count);
            }
        }
        String newString = sb.toString();
        return newString.length() < s.length() ? newString : s;
    }
}