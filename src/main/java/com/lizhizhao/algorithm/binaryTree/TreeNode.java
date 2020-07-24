package com.lizhizhao.algorithm.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }

  public List<Integer> preOrderTraversal(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    List<Integer> res = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.addFirst(root);
    while(!stack.isEmpty()) {
      TreeNode node = stack.removeFirst();
      res.add(node.val);
      if (node.right != null) {
        stack.addFirst(node.right);
      }
      if (node.left != null) {
        stack.addFirst(node.left);
      }
    }
    return res;
  }

  public List<Integer> inOrderTraversal(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    List<Integer> res = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while(node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }
      node = stack.removeLast();
      res.add(node.val);
      node = node.right;
    }
    return res;
  }

  public List<Integer> postrderTraversal(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    LinkedList<Integer> res = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.addFirst(root);
    while(!stack.isEmpty()) {
      TreeNode node = stack.removeFirst();
      res.addFirst(node.val);
      if (node.left != null) {
        stack.addFirst(node.left);
      }
      if (node.right != null) {
        stack.addFirst(node.right);
      }
    }
    return res;
  }
}
