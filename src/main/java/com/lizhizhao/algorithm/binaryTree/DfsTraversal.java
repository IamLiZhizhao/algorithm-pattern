package com.lizhizhao.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * DFS:深度优先搜索
 * @author lizhizhao
 * @since 2020-07-24 14:18
 */
public class DfsTraversal {

    /**
     * DFS 深度搜索-从上到下
     * @param root
     * @return
     */
    public List<Integer> dfsUpToDown(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left, res);
        dfs(node.right, res);
    }


    /**
     * DFS 深度搜索-从下向上（分治法）
     * @param root
     * @return
     */
    public List<Integer> prerderTraversal(TreeNode root) {
        return divideAndConquer(root);
    }

    public List<Integer> divideAndConquer(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        if (node == null) {
            return null;
        }
        // 分治
        List<Integer> left = divideAndConquer(node.left);
        List<Integer> right = divideAndConquer(node.right);
        // 合并结果
        result.add(node.val);
        if (left != null) {
            result.addAll(left);
        }
        if (right != null) {
            result.addAll(right);
        }
        return result;
    }

}
