/*
    In order to improve customer experience, Amazon has developed a system to provide recommendations 
    to the customers regarding the items they can purchase. Based on historical customer purchase information,
    an item association can be defined as - if an item A is ordered by a customer, then item B is also likely
    to be ordered by the same customer. All items that are linked together by an item association can be 
    considered to be in the same group, an item without any association to any other item can be considered
    to be in its own item association group of size 1.

    Given a list of item association relationships, write an algorithm that outputs the largest item association
    group. If two groups have the same number of items then select the group which contains the item that appears 
    first in lexicographic order.

    INPUT
    The input to the method consistsof an argument-
    itemAssociation, a list containing pairs of strings representing the items that are ordered together.

    OUTPUT
    Return a list of strings representing the largest item association group, sorted lexicographically.

    EXAMPLE
    Input:
    itemAssociation:
    [[item1,item2],
     [item3,item4],
     [item4,item5]
    ]

    Output:
    [item3, item4, item5]
*/
package placements.amazon;

import java.util.*;

public class LargestItemAssociation {
    public List<String> findLargest(List<PairString> itemAssociation) {
        List<String> ans = new ArrayList<String>();;
        Map<String, Set<String>> adj = new HashMap<>();
        int max = 0;
        for(PairString i : itemAssociation) {
            Set<String> set;
            if(adj.containsKey(i.first)) {
                set = adj.get(i.first);
                set.add(i.second);
                adj.put(i.second, set);
            } else {
                set = new HashSet<String>();
                set.add(i.first);
                set.add(i.second);
                adj.put(i.first,set);
                adj.put(i.second,set);
            }
            max = Math.max(set.size(), max);
        }
        String key=null;
        int last=0;
        for(String s : adj.keySet()) {
            int size = adj.get(s).size();
            if(key==null){
                key = s; 
                last = size;
                continue;
            }
            if(size == max) {
                if(s.compareTo(key) < 0 || size > last)
                key = s;
            }
            last = size;
        }
        Set<String> solset = adj.get(key);
        for(String k : solset) {
            ans.add(k);
        }
        Collections.sort(ans);
        return ans;
    }


    public static void main(String...s) {
        LargestItemAssociation a = new LargestItemAssociation();
        List<PairString> pairs = new ArrayList<>();
        pairs.add(new PairString("item3","item4"));
        pairs.add(new PairString("item1","item2"));
        pairs.add(new PairString("item4","item5"));
        System.out.println(a.findLargest(pairs));
    }
}

class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
