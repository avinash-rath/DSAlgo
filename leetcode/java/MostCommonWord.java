/*
819. Most Common Word
Easy

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

 

Note:

    1 <= paragraph.length <= 1000.
    0 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.

Accepted
178,788
Submissions
397,106
*/


class Solution {
    String ans;
    int max;
    Set<String> bans;
    Map<String, Integer> freq;
    
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<Character> puncts = new HashSet<Character>();
        puncts.add('!');
        puncts.add('?');
        puncts.add('\'');
        puncts.add(',');
        puncts.add(';');
        puncts.add('.');
        bans = new HashSet<String>(Arrays.asList(banned));
        freq = new HashMap<>();
        String [] para = paragraph.split(" ");
        max = 0;
        ans ="";
        for(String s : para) {
            String word="";
            for(int i = 0; i<s.length(); i++) {
                if(puncts.contains(s.charAt(i))){
                    word = word.toLowerCase();
                    processWord(word);
                    word = "";
                    continue;
                }
                word += s.charAt(i);
            }
            word = word.toLowerCase();
            processWord(word);
        }
        return ans;
    }
    
    private void processWord(String word) {
        if(word.equals("")) return;
        if(!bans.contains(word)) {
                freq.merge(word, 1, Integer::sum);
                if(freq.get(word) > max) {
                    max = freq.get(word);
                    ans = word;
                }
        }
    }
}
