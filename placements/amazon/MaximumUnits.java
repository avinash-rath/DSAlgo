package amazon;
import java.util.*;
/**

  An amazon warehouse manager needs to create a shipment to fill a truck. All of the products in the
  warehouse are in the boxes of the same size. Each product is packed in some number of units per box.

  Given the number of boxes the truck can hold, write an algorithm to determine the maximum number of 
  units of any mix of products that can be shipped.

  INPUT
  The input to the method conists of five arguments:
  num, an integer representing number of products;
  boxes, a list of integers representing the number of available boxes for products;
  unitSize, an integer representing the number of units packed in each box;
  unitsPerBox, a list of integers representing the number of units packed in each box;
  truckSize, an integer representing the number of boxes the truck can carry.

  OUTPUT
  Return an integer representing the maximum units can be carried by the truck.

  EXAMPLE

  Input -
  num = 3
  boxes = [1,2,3]
  unitSize = 3
  unitsPerBox = [3,2,1]
  truckSize = 3
  
  Output -
  7
 */
public class MaximumUnits {
    public long maxUnits(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {
        long ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(num, Collections.reverseOrder());
        Map<Integer, Integer> sizes = new HashMap<>();
        for(int i =0; i< num; i++) {
            sizes.put(boxes.get(i),unitsPerBox.get(i));
            queue.add(unitsPerBox.get(i));
        }
        while(truckSize > 0 && queue.size()>0) {
            int curr = queue.poll();
            long currBoxes = (long)sizes.get(curr);
            System.out.println(curr+" "+currBoxes);
            ans += Math.min(truckSize, currBoxes) * curr;
            truckSize -= currBoxes;
        }
        return ans;
    }

    public static void main(String...s) {
        MaximumUnits test = new MaximumUnits();
        List<Integer> boxes = new ArrayList<Integer>();
        List<Integer> unitsPerBox = new ArrayList<Integer>();
        Collections.addAll(boxes, 1,2,3,4);
        Collections.addAll(unitsPerBox, 3,2,1,4);
        System.out.println(test.maxUnits(4, boxes, 4, unitsPerBox, 3));
    }
}
