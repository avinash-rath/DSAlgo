/*
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 

Note:

    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.

*/




/*
// Example of over complicating things
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int []> seenAt = new HashMap<Character, int []>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int [] arr = seenAt.getOrDefault(c, new int[] {i,i});
            arr[1] = i;
            seenAt.put(c, arr);
        }
        List<int[]> arr = new ArrayList<int[]>(seenAt.values());
        List<Integer> ans = new ArrayList<Integer>();
        arr.sort(new MyComparator());
        // for(int[] i: arr) System.out.print("["+i[0]+", "+i[1]+"] ");
        int maxNow=0, maxLast=0,c = 0;
        for(int[] i : arr) {
            if(c == 0) {
                maxNow = i[1];
                c++;
                continue;
            }
            if(i[0]>maxNow) {
                ans.add(maxNow - maxLast + 1);
                maxLast = maxNow+1;
                maxNow = i[1];
            } else {
                maxNow = Math.max(maxNow, i[1]);
            }
            c++;
        }
        ans.add(maxNow - maxLast + 1);
        return ans;
    }
}
class MyComparator implements Comparator<int[]>{

    @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[0] > o2[0]) return 1;
        else if (o1[0] == o2[0]) return 0;
        else return -1;
    }

}
*/
