/**
 *	Given a binary tree, find its minimum depth.
 *
 *	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 *	Author: matao
 *
 */


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        if (root.left != null){
            leftDepth = minDepth(root.left) + 1 ;
        }
        int rightDepth = Integer.MAX_VALUE;
        if (root.right != null){
            rightDepth = minDepth(root.right) + 1;
        }
        
        return leftDepth < rightDepth ? leftDepth : rightDepth;
    }
}