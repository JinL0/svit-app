package com.svit.java.l4;
/**
 * Definition for binary tree
 * e.g                  1
 *                   /    \
 *                  2      3
 *                 / \    /
 *                4   5  6
 *               /
 *              7
 * @author sv-it
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;


public class BinaryTreeInOrderTraversal
{
    public static void main(String[] args)
    {
    	TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;

        System.out.println(inorderTraversalIterative(node1));
        System.out.println(inorderTraversalRecursive(node1));
        System.out.println(inorderTraversalRecursive1(node1));

        System.out.println(preorderTraversalIterative(node1)); //use queue instead a stack since each time FIFO
        System.out.println(preorderTraversalRecursive(node1));
        System.out.println(preorderTraversalRecursive1(node1));

        System.out.println(PostorderTraversalIterative(node1));
        
    } 	
    
    /**
     * ITERATIVE: in order travel with stack
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root==null) return result;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        
        //cur!=null when root or not the left leaf
        while(!s.isEmpty() || cur!=null){
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            
        }
        
        return result;
    }
    

	
	/**
	 * RECURSIVE without return: in order travel
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    inorderTraversalRecursiveHelper(root, result);
	    
	    return result;
	    
	}
	
	public static void inorderTraversalRecursiveHelper(TreeNode cur, ArrayList<Integer> result){
		if (cur==null) 
			return;
		
		inorderTraversalRecursiveHelper(cur.left, result);
		result.add(cur.val);
		inorderTraversalRecursiveHelper(cur.right, result);
		
	}
    
    
	/**
	 * RECURSIVE WITH return: in order travel
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> inorderTraversalRecursive1(TreeNode root) {
	    
	    
	   return inorderTraversalRecursiveHelper1(root);
	    
	}
	
	public static ArrayList<Integer> inorderTraversalRecursiveHelper1(TreeNode cur){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (cur==null) 
			return result;
		
		result.addAll(inorderTraversalRecursiveHelper1(cur.left));
		result.add(cur.val);
		result.addAll(inorderTraversalRecursiveHelper1(cur.right));
		
		return result;
	}

    /**
     * ITERATIVE: Pre order travel with Queue
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root==null) return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        s.push(root);

        while(!s.empty()){
            cur = s.pop();
            result.add(cur.val);
            if(cur.right != null){
                s.push(cur.right);
            }
            if(cur.left != null){
                s.push(cur.left);
            }

        }

        return result;
    }


    /**
     * RECURSIVE without return: in order travel
     * @param root
     * @return
     */
    public static ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        preorderTraversalRecursiveHelper(root, result);

        return result;

    }

    public static void preorderTraversalRecursiveHelper(TreeNode cur, ArrayList<Integer> result){
        if (cur==null)
            return;

        result.add(cur.val);
        preorderTraversalRecursiveHelper(cur.left, result);
        preorderTraversalRecursiveHelper(cur.right, result);

    }

    public static ArrayList<Integer> preorderTraversalRecursive1(TreeNode root) {


        return preorderTraversalRecursiveHelper1(root);

    }

    public static ArrayList<Integer> preorderTraversalRecursiveHelper1(TreeNode cur){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (cur==null)
            return result;

        result.add(cur.val);
        result.addAll(preorderTraversalRecursiveHelper1(cur.left));
        result.addAll(preorderTraversalRecursiveHelper1(cur.right));

        return result;
    }


    /**
     * ITERATIVE: Post order travel with Queue
     * @param root
     * @return
     */
    public static List<Integer> PostorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root==null) return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        s.push(root);
        TreeNode prev = null;
        while(!s.empty()){
            cur = s.peek();
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    s.push(cur.left);
                } else if (cur.right != null){
                    s.push(cur.right);
                }
                else{
                    s.pop();
                    result.add(cur.val);
                }
            } else if(cur.left == prev) {
                if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    s.pop();
                    result.add(cur.val);
                }
            } else if (cur.right == prev){
                s.pop();
                result.add(cur.val);
            }
            prev = cur;
        }

        return result;
    }



    

}

