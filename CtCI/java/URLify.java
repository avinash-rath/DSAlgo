/**
 * 1.3
 * URLify
 * Write a method to replace all spaces in a string with "%20". You may assume that
 * the string has sufficient spece at the end to hold the additional characters, and
 * that you are gven the true length of the string.
 * 
 * NOTE : in java use a character array instead of string as string objects are immutable.
 * 
 * input - "Mr John Smith    ", 13
 * output- "Mr%20John%20Smith"
 */
public class URLify {
    // public String urlify(String str) { // using StringBuilder, so that it is one pass. 
    //     StringBuilder stringBuilder = new StringBuilder();
    //     for(char i : str.toCharArray()) {
    //         if(i == ' ') stringBuilder.append("%20");
    //         else stringBuilder.append(i);
    //     }
    //     return stringBuilder.toString();
    // }
    public void urlify(char [] str, int trueLength) { // using char[] and truelength
        int spaces = 0, index;
        for(int i = 0; i< trueLength; i++){
            if(str[i] == ' ') spaces++;
        }
        index = trueLength + spaces*2;
        for(int i = trueLength-1; i>=0; i--) {
            if(str[i]==' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index-=3;
            } else {
                str[index-1] = str[i];
                index--;
            }
        }
    }
}