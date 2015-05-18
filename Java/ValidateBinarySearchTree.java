/**
 *	Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 *	Assume a BST is defined as follows:
 *
 *	The left subtree of a node contains only nodes with keys less than the node's key.
 *	The right subtree of a node contains only nodes with keys greater than the node's key.
 *	Both the left and right subtrees must also be binary search trees.
 *
 *	An example:
 *
 * 	   		1
 *	 	   / \
 *		  2   3
 *  		 /
 * 			4
 * 			 \
 *  	 	  5
 *	The above binary tree is serialized as {1,2,3,#,#,4,#,#,5}.
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

public class ValidateBinarySearchTree {
	/**
	 *	wrong answer
	 *  仅仅判断了左右孩子结点小于大于根结点，并没有判断其左右子树
	 *
	 *	public boolean isValidBST(TreeNode root) {
	 *		if(root == null) {
	 *			return true;
	 *		}
	 *		if(root.left != null && root.left.val >= root.val) {
	 *			return false;
	 *		}
	 *		if(root.right != null && root.right.val >= root.val) {
	 *			return false;
	 *		}
	 *		return isValidBST(root.left) && isValidBST(root.right);
     *	}
     */

	// 利用binary search tree中序遍历后递增的特性
	public static boolean isValidBST1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();  
		inOrderTraversal(root, list);
		for (int i = 1; i < list.size(); i++) {  
            if (list.get(i) <= list.get(i - 1)) {
            	return false;  
            }
        }  
        return true; 
	}

	public static void inOrderTraversal(TreeNode root, List<Integer> list) {  
        if (root == null) {
        	return;  
        }
        inOrderTraversal(root.left, list);  
        list.add(root.val);  
        inOrderTraversal(root.right, list);  
    }  


    private TreeNode lastNode = null

    public boolean isValidBST2(TreeNode root) {
    	if(root != null) {
    		if(!isValidBST2(root.left)) {
    			return false;
    		}
    		if(lastNode != null && lastNode.val >= root.val) {
    			return false;
    		}
    		lastNode = root;
    		if(!isValidBST2(root.right)) {
    			return false;
    		}
    	}
    	return true;
	}

	public static void main(String[] args) {
		
	}
}