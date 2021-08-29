package swiggy;

import java.util.PriorityQueue;

/**
 * Minimize the sum calculated by repeatedly removing any two elements and inserting their sum to the Array
Difficulty Level : Easy
Given N elements, you can remove any two elements from the list, note their sum, and add the sum to the list. Repeat these steps while there is more than a single element in the list. The task is to minimize the sum of these chosen sums in the end.
Examples: 
 

Input: arr[] = {1, 4, 7, 10} 
Output: 39 
Choose 1 and 4, Sum = 5, arr[] = {5, 7, 10} 
Choose 5 and 7, Sum = 17, arr[] = {12, 10} 
Choose 12 and 10, Sum = 39, arr[] = {22}
Input: arr[] = {1, 3, 7, 5, 6} 
Output: 48 


 Used Priority Queue
 */

class MinimizeCalculateSum {
    public int minimizeSum(int [] array) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i < array.length; i++) { 
            pq.add(array[i]); 
        }
        while(pq.size() > 1) {
            int currSum = pq.poll() + pq.poll();
            // System.out.println(currSum);
            pq.add(currSum);
            sum += currSum;
        }
        // sum += pq.poll();
        return sum;
    }
}