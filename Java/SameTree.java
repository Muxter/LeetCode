/** Given two binary trees, write a function to check if they are equal or not.
 *
 *  Two binary trees are considered equal if they are structurally identical 
 *  and the nodes have the same value.
 *
 *	Author : matao
 */

public class SameTree {
	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int value) {
			this.value = value;
		}
	}

	/**
	 *   
	 *	注意空树时情况
	 */
	private	boolean isSameTree1(TreeNode p, TreeNode q) {
		if(p == null && q == null) //两树均为空
			return true;
		if(p != null && q != null) { //两树均不为空
			if(p.value == q.value) {
				if(!isSameTree1(p.left, q.left) || !isSameTree1(p.right, q.right))
					return false;
				return true;
			}
		}
		//仅有一树为空
		return false;
	}	
	
	// isSameTree1精简版
	private boolean isSameTree2(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		return (p.value == q.value) && 
				isSameTree2(p.left, q.left) && 
				isSameTree2(p.right, q.right);
	}

	// 非递归
	private boolean isSameTree3(TreeNode p, TreeNode q) {
		//TODO
		return false;
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}
}
