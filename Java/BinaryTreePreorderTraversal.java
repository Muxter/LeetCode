/**
 *	Given a binary tree, return the preorder traversal of its nodes' values.
 *
 *	For example:
 *	Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 *	return [1,2,3].
 *
 *	Author: matao
 */

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

//  Definition for binary tree
class TreeNode {
  	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 

public class BinaryTreePreorderTraversal {

	//Recursive solution
	// divide and conquer
	public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
            
        result.add(root.val);
        
        List<Integer> left = preorderTraversal1(root.left);
        List<Integer> right = preorderTraversal1(root.right);
        
        result.addAll(left);
        result.addAll(right);
        return result;
    }

//--------------------------------------
    // Traverse
	public static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}  

	public static void traverse(TreeNode root, List<Integer> result) {
		if(root == null)
			return;
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}
//--------------------------------------
	// Non-Recursion 
	public static List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			return result;
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if(root.right != null) {
				stack.push(node.right);
			}
			if(root.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}  


    public static void main(String[] args) {
    	
    }
}