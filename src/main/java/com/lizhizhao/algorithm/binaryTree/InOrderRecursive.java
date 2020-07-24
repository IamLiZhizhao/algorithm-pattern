package com.lizhizhao.algorithm.binaryTree;

/**
 * 中序遍历递归
 */
public class InOrderRecursive {
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // 在递归中间写操作
        System.out.println(root.val);
        inOrder(root.right);
    }
}
