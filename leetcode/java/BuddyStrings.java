/*
859. Buddy Strings
Easy

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true

Example 2:

Input: A = "ab", B = "ab"
Output: false

Example 3:

Input: A = "aa", B = "aa"
Output: true

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

 

Constraints:

    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.

Accepted
51,378
Submissions
187,866
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int [] table = new int[26];
        List<Integer> idx = new ArrayList<Integer>();
        int diff = 0;
        for(int i =0; i<A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                diff++;
                if(diff>2) return false;
                idx.add(i);
            }
            table[A.charAt(i)-'a']++;
        }
        if(diff == 0) {
            for(int c : table) if(c>1) return true;
            return false;
        }
        else if(diff!=2) return false;
        else {
            return A.charAt(idx.get(0)) == B.charAt(idx.get(1)) && A.charAt(idx.get(1)) == B.charAt(idx.get(0));
        }
    }
}
