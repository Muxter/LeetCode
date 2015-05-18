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
	public static int minDepth(TreeNode root) {
		if (root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        if(rightDepth == 0) {
            return leftDepth + 1;
        }
        return leftDepth + 1 < rightDepth + 1 ? leftDepth + 1: rightDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode testTree1 = new TreeNode(1);
        System.out.println(minDepth(testTree1));
        TreeNode testTree2 = null;
        System.out.println(minDepth(testTree2));
        TreeNode testTree3 = new TreeNode(1);
        testTree3.left = new TreeNode(2);
        System.out.println(minDepth(testTree3));
    }
}