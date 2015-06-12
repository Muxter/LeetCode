/**
 *	Invert a binary tree.
 *
 *    	  4
 *  	/   \
 * 	   2     7
 * 	  / \   / \
 *	 1   3 6   9
 *
 *  to
 *
 *       4
 *     /   \
 *    7     2
 *	 / \   / \
 *	9   6 3   1
 *
 *	Trivia:
 *	This problem was inspired by this original tweet by Max Howell:
 *	Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
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

public class InvertBinaryTree {
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		root.left = invertTree(root.left);
		root.right = invertTree(root.right);

		return root;
    }

    public static void traversePreOrder(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	System.out.print(root.val + " ");
    	traversePreOrder(root.left);
    	traversePreOrder(root.right);
    }

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4);		
		TreeNode node2 = new TreeNode(2);		
		TreeNode node7 = new TreeNode(7);		
		TreeNode node1 = new TreeNode(1);		
		TreeNode node3 = new TreeNode(3);		
		TreeNode node6 = new TreeNode(6);		
		TreeNode node9 = new TreeNode(9);		

		node4.left = node2;
		node4.right = node7;

		node2.left = node1;
		node2.right = node3;

		node7.left = node6;
		node7.right = node9;

		traversePreOrder(node4);

		System.out.println();

		traversePreOrder(invertTree(node4));
	}
}