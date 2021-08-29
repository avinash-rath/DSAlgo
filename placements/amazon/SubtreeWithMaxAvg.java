package placements.amazon;

import java.util.*;

/*
Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.

Example 1:

Input:
		 20
	   /   \
	 12     18
  /  |  \   / \
11   2   3 15  8

Output: 18
Explanation:
There are 3 nodes which have children in this tree:
12 => (11 + 2 + 3 + 12) / 4 = 7
18 => (18 + 15 + 8) / 3 = 13.67
20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

18 has the maximum average so output 18.

*/

public class SubtreeWithMaxAvg {
    int ans;
    double max;
    public int findSubtree(NAryTreeNode root) {
        max = Double.MIN_VALUE;
        dfs(root);
        return ans;
    }

    private double [] dfs(NAryTreeNode node) {
        int count=1;
        double sum = node.val;
        if(node.children.size() == 0) {
            return new double [] {node.val, 1};
        }
        for(NAryTreeNode child : node.children) {
            double [] ret = dfs(child);
            sum += (double)ret[0];
            count+=ret[1];
        }
        if(sum/count>=max) {
            max = sum/count;
            ans = node.val;
        }
        return new double [] {sum/count, count};
    }

    public static void main(String...s) {
        NAryTreeNode one = new NAryTreeNode(11);
        NAryTreeNode two = new NAryTreeNode(2);
        NAryTreeNode three = new NAryTreeNode(3);
        NAryTreeNode four = new NAryTreeNode(15);
        NAryTreeNode five = new NAryTreeNode(8);
        NAryTreeNode six = new NAryTreeNode(12);
        NAryTreeNode seven = new NAryTreeNode(18);
        NAryTreeNode eight = new NAryTreeNode(20);
        NAryTreeNode nine = new NAryTreeNode(120);
        six.children.add(one);
        six.children.add(two);
        six.children.add(three);
        seven.children.add(four);
        seven.children.add(five);
        eight.children.add(six);
        eight.children.add(seven);
        one.children.add(nine);
        SubtreeWithMaxAvg test = new SubtreeWithMaxAvg();
        System.out.println(test.findSubtree(eight));
    }
}

class NAryTreeNode {
    int val;
    List<NAryTreeNode> children;
    NAryTreeNode(int val) {
        this.val = val;
        children = new ArrayList<NAryTreeNode>();
    }
}
