
package med;
/*1110. Delete Nodes And Return Forest

Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.
*/

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.

public class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}

class Solution {
    // keep track of nodes to delete using their values.
    private boolean[] toDelete = new boolean[1001];
    // store the resulting forest after deletions.
    private List<TreeNode> forest = new ArrayList<>();

    // Main function to delete nodes and return the remaining forest as a list.
    public List<TreeNode> delNodes(TreeNode root, int[] delNodes) {
        // Populate the toDelete array to mark nodes that need to be deleted.
        for (int value : delNodes) {
            toDelete[value] = true;
        }
    
        if (deleteAndReturnValidRoot(root) != null) {
            forest.add(root);
        }
        return forest;
    }

    // handle deletions.
    private TreeNode deleteAndReturnValidRoot(TreeNode node) {
        if (node == null) {
            return null;
        }
        // Recursive with the left and right subtrees.
        node.left = deleteAndReturnValidRoot(node.left);
        node.right = deleteAndReturnValidRoot(node.right);
        // If current node is not to be deleted, return it.
        if (!toDelete[node.val]) {
            return node;
        }
        // If this node is deleted, add its children to the forest.
        if (node.left != null) {
            forest.add(node.left);
        }
        if (node.right != null) {
            forest.add(node.right);
        }
        // Return null when node is deleted.
        return null;
    }
}