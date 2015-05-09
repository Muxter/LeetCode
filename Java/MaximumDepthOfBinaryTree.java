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
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int leftMaxDepth = 1, rightMaxDepth = 1;
		if(root.left != null) {
			leftMaxDepth += maxDepth(root.left);
		}
		if(root.right != null) {
			rightMaxDepth += maxDepth(root.right);
		}
		return leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth;
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
