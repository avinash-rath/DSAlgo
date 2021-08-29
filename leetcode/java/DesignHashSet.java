package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
*/

/*
stupid solution
class MyHashSet {
    boolean [] a;
    // Initialize your data structure here.
    public MyHashSet() {
        a = new boolean [1000001];
    }
    
    public void add(int key) {
        a[key] = true;
    }
    
    public void remove(int key) {
        a[key] = false;
    }
    
    // Returns true if this set contains the specified element 
    public boolean contains(int key) {
        return a[key];
    }
}
*/





class DesignHashSet {
    private List<Integer> [] hashset;
    // Initialize your data structure here. /
    static int capacity = 2000;
    private int hash(int number) {
      return number%capacity;
    }
    public DesignHashSet() {
        hashset = new List[capacity];
    }
    
    public void add(int key) {
        int k = hash(key);
        if(contains(k)) return;
        if(hashset[k] == null) {
          List<Integer> lst = new ArrayList<Integer>();
          lst.add(key);
          hashset[k] = lst;
        } else {
          hashset[k].add(key);
        }
    }
    
    public void remove(int key) {
      int k = hash(key);
      if(!contains(hash(key))) return;
      hashset[k].remove(new Integer(key));
    }
    
    // Returns true if this set contains the specified element//
    public boolean contains(int key) {
      int k = hash(key);
      if(hashset[k] == null) return false;
      return hashset[k].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

