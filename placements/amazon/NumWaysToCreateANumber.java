package placements.amazon;

import java.util.*;

public class NumWaysToCreateANumber {
    public int numWays(int m, int n) {
        int ans = 0;
        int tempN = n;
        int lastMin = 1;
        Stack<Integer> stack = new Stack<Integer>();
        while(m-->0) {
            stack.push(tempN);
            tempN /= 2;
        }
        ans = stack.pop() - lastMin+1;
        while(!stack.isEmpty()) {
            int hi = stack.pop();
            lastMin *= 2;
            ans *= (hi-lastMin + 1);
            System.out.println(hi+" "+lastMin+" "+ans);
        }
        return ans;
    }

    public static void main(String ...s) {
        NumWaysToCreateANumber test = new NumWaysToCreateANumber();
        System.out.println(test.numWays(3,9));
    }
}
