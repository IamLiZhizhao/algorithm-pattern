package com.lizhizhao.algorithm.binaryTree;

/**
 * 前序遍历递归
 */
public class PreOrderRecursive {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
