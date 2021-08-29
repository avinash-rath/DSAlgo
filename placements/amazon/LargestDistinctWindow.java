package placements.amazon;
/*

Smallest distinct window
Medium Accuracy: 43.8% Submissions: 25753 Points: 4

Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca”.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case in a new line print the length of the smallest such string.

Constraints:
1 <= T <= 100
1 <= |S| <= 105

Example:
Input:
2
aabcbcdbca
aaab

Output:
4
2

Explanation:
Testcase 1: Smallest window size is 4 which is of "dbca" which consists all characters of the string.
*/
/*package whatever //do not write package name here */

import java.util.*;

class LargestDistinctWindow {
	public static void main (String[] args) {
		Set<Character> chars = new HashSet<>();
		int size = 0;
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-- >0) {
		    String s = sc.next();
		    for(int i = 0; i<s.length(); i++){
		        chars.add(s.charAt(i));
		    }
		    size = chars.size();
		    if(s.length() == size) {
		        System.out.println(size);
            }
            // System.out.println(chars);
		    while(size > 0) {
		        if(checkString(s,size)) {
                    System.out.println(size);
		            break;
		        }
		        size--;
		    }
		    // System.out.println(size); // which is 0
		}
	}
	
	private static boolean checkString(String s, int k) {
        if(k==0) return true;
	    int [] table = new int [26];
	    int start = 0, end = 0;
	    while(start <= end && end < s.length() ) {
	        table[s.charAt(end)-'a']++;
	        while(table[s.charAt(end)-'a'] != 1) {
	            table[s.charAt(start)-'a']--;
	            start++;
	        }
	        if(end-start+1 > k) {
	            table[s.charAt(start)-'a']--;
	            start++;
	        }
	        if(end-start+1 == k) {
				System.out.println(s.substring(start,end+1));
	            return true;
            }
            end++;
	    }
	    return false;
	}
	
}