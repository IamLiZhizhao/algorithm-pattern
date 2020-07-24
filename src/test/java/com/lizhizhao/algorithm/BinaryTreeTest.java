package com.lizhizhao.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@Slf4j
@SpringBootTest
public class BinaryTreeTest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);

        return leftLen > rightLen ? 1 + leftLen : 1 + rightLen;
    }

    // 110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftLen = div(root.left);
        int rightLen = div(root.right);

        return !(leftLen == -1 || rightLen == -1 || leftLen - rightLen > 1 || rightLen - leftLen > 1);
    }

    public int div(TreeNode root) {
        if (root == null) return 0;

        int leftLen = div(root.left);
        int rightLen = div(root.right);

        if (leftLen == -1 || rightLen == -1 || leftLen - rightLen > 1 || rightLen - leftLen > 1)
            return -1;

        return leftLen > rightLen ? 1 + leftLen : 1 + rightLen;
    }





    @Test
    void ResultTest() {
        TreeNode root = new TreeNode(1);

//        String content = [1,2,2,3,3,null,null,4,4];


    }


}
