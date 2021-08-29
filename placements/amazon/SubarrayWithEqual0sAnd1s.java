package placements.amazon;

import java.util.*;

public class SubarrayWithEqual0sAnd1s {
    public int findSubarray(int [] arr) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i<arr.length; i++) {
            if(arr[i]==0) arr[i] = -1;
            sum += arr[i];
            System.out.print(sum+" ");
            if(map.containsKey(sum)) {
                ans = Math.max(ans,i-map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
        System.out.println("");
        return ans;
    }

    public static void main(String...s) {
        SubarrayWithEqual0sAnd1s test = new SubarrayWithEqual0sAnd1s();
        System.out.println(test.findSubarray(new int [] {0,1,0,1}));
    }
}
