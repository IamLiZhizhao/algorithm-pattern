package com.lizhizhao.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS:广度优先搜索
 *
 * @author lizhizhao
 * @since 2020-07-24 14:21
 */
public class BfsTraversal {

    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // size记录当前层有多少元素（遍历当前层，再添加下一层）
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
