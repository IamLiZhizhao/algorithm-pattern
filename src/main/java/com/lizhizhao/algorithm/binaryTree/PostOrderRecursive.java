package com.lizhizhao.algorithm.binaryTree;

/**
 * 后序递归
 */
public class PostOrderRecursive {

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        // 在递归后面写操作
        System.out.println(root.val);
    }

}