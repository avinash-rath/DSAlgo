/**
 * 1.5
 * There are three types of edits that can be performed on strings: insert
 * a char, remove a char, or replace a char. Given two strings, write a 
 * function to check if ther are one edit(or zero edits) away.
 * EXAMPLE
 * pale,ple -> true
 * pales,pale -> true
 * pale,bale -> true
 * pale,bake -> false
 */

public class OneAway {
    public boolean isOneAway(String str1, String str2) {
        // corner case, if length difference is more than one, return false
        int l1 = str1.length(), l2 = str2.length();
        if(Math.abs(l1-l2) > 1) return false;
        boolean areSameLength = l1 == l2;
        boolean ok = true;
        int i=0,j=0;
        while(i<l1 && j<l2) {
            if(str1.charAt(i) == str2.charAt(j)) {
                i++;j++; continue;
            } else {
                if(!ok) return false;
                if(areSameLength) {i++; j++;}
                else if(l1>l2) i++;
                else j++;
                ok = false;
            }
        }
        return (l1-i <= 1) && (l2-j<=1);
    }
}