/**
 *	Given a binary tree, find its maximum depth.
 *	The maximum depth is the number of nodes along the longest path 
 *	from the root node down to the farthest leaf node.
 *
 *	Author : matao
 */

class TreeNode {
	int value;
 	TreeNode left;
 	TreeNode right;
 	public TreeNode(int value) {
 		this.value = value;
 	}
}

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if(root == null)
            return  0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return maxLeft + 1 > maxRight + 1 ? maxLeft + 1 : maxRight + 1;
	}

	public static void main(String[] args) {
		TreeNode testTree1 = new TreeNode(1);
		System.out.println(maxDepth(testTree1));
		TreeNode testTree2 = null;
		System.out.println(maxDepth(testTree2));
		TreeNode testTree3 = new TreeNode(1);
		testTree3.left = new TreeNode(2);
		System.out.println(maxDepth(testTree3));
	}
}
