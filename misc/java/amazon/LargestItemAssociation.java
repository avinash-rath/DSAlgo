package amazon;

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
            } else {
                set = new HashSet<String>();
                set.add(i.first);
                set.add(i.second);
                adj.put(i.first,set);
                adj.put(i.second,set);
            }
            max = Math.max(set.size(), max);
        }
        System.out.println(max);
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
                System.out.println(adj.get(s).size() + " "+ s);
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
        pairs.add(new PairString("item1","item2"));
        pairs.add(new PairString("item3","item4"));
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
