package com.svit.java.l6;
import java.util.*;

public class zigzaglevelorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        int level = 0;
        boolean order = true;
        findSublist(root, result, level, order);
        Collections.reverse(result);
        return result;

    }

    private void findSublist(TreeNode root, List<List<Integer>> result, int level, boolean order){
        if(root==null){
            return;
        }
        List<Integer> sublist;
        if(level < result.size()){
            sublist = result.get(level);
        } else {
            sublist = new ArrayList<>();
            result.add(sublist);
            sublist = result.get(level);
        }
        if(order){
            sublist.add(root.val);
        }else{
            sublist.add(0, root.val);
        }
        int temp = level + 1;
        findSublist(root.left, result, level, !order);
        findSublist(root.right, result, level, !order);
    }

}
