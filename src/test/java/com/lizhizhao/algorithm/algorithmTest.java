package com.lizhizhao.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

@Slf4j
@SpringBootTest
public class algorithmTest {

    //1160. 拼写单词
    public int countCharacters(String[] words, String chars) {
        int[] charC = charCount(chars);
        int maxLen = 0;
        for (String word : words) {
            boolean flag = true;
            int[] charWord = charCount(word);
            for (int i = 0; i < 26; i++) {
                if (charC[i] < charWord[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) maxLen += word.length();
        }
        return maxLen;
    }

    public int[] charCount(String s) {
        char[] charArray = s.toCharArray();
        int[] charCount = new int[26];
        for (char c : charArray) {
            charCount[c-'a']++;
        }
        return charCount;
    }

    // 17.16. 按摩师 dp
    public int massage(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    // topK
    public int topK(int[] nums,int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k || num > queue.peek()){
                queue.offer(num);
            }
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    // 表面积
    public int surfaceArea(int[][] grid) {


        return 0;
    }


    // 820. 单词的压缩编码
    public int minimumLengthEncoding(String[] words) {
        int len = words[0].length();
        char[] wordChar;
        for(int i=1; i<words.length; i++){
//            words[i].lastIndexOf();
        }
        return 0;
    }

    private char[] getCharArr(String word){
        char[] charArray = word.toCharArray();


        return null;
    }

    //面试题62. 圆圈中最后剩下的数字
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int lastN = 0;
        while (n>1){
            lastN = (lastN + m - 1) % n;
            list.remove(lastN);
            n--;
        }
        return list.get(0);
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        char[] charArray = seq.toCharArray();
        int d = 0;
        int k = 0;
        for (char c : charArray) {
            if (c == '('){
                d++;
                res[k++] = d%2;
            } else {
                res[k++] = d%2;
                d--;
            }
        }
        return res;
    }

    //面试题 01.07 旋转矩阵
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n != 0) {
            int[][] rotate = new int[n][];
            for (int i = 0; i < n; i++) {
                for (int j = n-1; j >=0 ; j--) {
                    rotate[i][n-1-j] = matrix[j][i];
                }
            }
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate.length; j++) {
                    matrix[i][j] = rotate[i][j];
                }
            }
        }
    }



    /**
    1.去掉前导空格
    2.再是处理正负号
    3.识别数字，注意越界情况。
    */
    // 8. 字符串转换整数 (atoi)
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length()<=0) return 0;
        char[] chars = str.toCharArray();
        boolean negitive = false;
        int res = 0;
        int idx = 0;
        if (chars[idx] == '-') {
            negitive = true;
            idx++;
        }
        else if (chars[idx] == '+') {
            negitive = false;
            idx++;
        }
        else if (!Character.isDigit(chars[idx])) return 0;

        while (idx < str.length() && Character.isDigit(chars[idx])){
            int x = chars[idx] - '0';
            if (res > (Integer.MAX_VALUE - x)/10) return negitive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + x;
            idx++;
        }

        return negitive ? -res : res;
    }

//    给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//    示例:
//    输入: [1,2,3]
//    输出:
//            [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//            ]
    // 46.全排列
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList();
//        int numsLength = nums.length;
//        if (numsLength == 0) return result;
//        if (numsLength == 1) {
//            List<Integer> res = new ArrayList<>();
//            res.add(nums[0]);
//            result.add(res);
//            return result;
//        }
//
//
//        return result;
//    }

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    void main() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);
    }

    //60. 第k个排列
    //给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
    //按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    //"123" "132" "213" "231" "312" "321"
    //给定 n 和 k，返回第 k 个排列。
    //给定 n 的范围是 [1, 9]。
    //给定 k 的范围是[1,  n!]。
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        boolean[] used = new boolean[n];
        List<Integer> temp = new ArrayList<>();

        return dfs1(nums, n, 0, used, temp, res, k);
    }

    private String dfs1(List<Integer> nums,int len, int dept, boolean[] used, List<Integer> temp, List<List<Integer>> res,int k){
        if (len == dept) {
            res.add(new ArrayList<>(temp));
            if (res.size() == k){
                List<Integer> integers = res.get(k - 1);
                StringBuilder sb = new StringBuilder();
                for (Integer integer : integers) {
                    sb.append(integer);
                }
                return sb.toString();
            }
        }

        for (int i = 1; i <= len ; i++) {
            if (!used[i-1]) {
                temp.add(nums.get(i-1));
                used[i-1] = true;

                String dfs1 = dfs1(nums, len, dept + 1, used, temp, res, k);
                if (!StringUtils.isEmpty(dfs1)){
                    return dfs1;
                }

                used[i-1] = false;
                temp.remove(temp.size()-1);
            }
        }
        return "";
    }

    //31. 下一个排列
    //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //必须原地修改，只允许使用额外常数空间。
    //
    //以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    //1,2,3 → 1,3,2
    //3,2,1 → 1,2,3
    //1,1,5 → 1,5,1
    public void nextPermutation(int[] nums) {

    }

    // 快乐数编写一个算法来判断一个数 n 是不是快乐数。
    //「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    //如果 n 是快乐数就返回 True ；不是，则返回 False 。
    //示例：
    //输入：19
    //输出：true
    //解释：
    //1~2 + 9~2 = 82
    //8~2 + 2~2 = 68
    //6~2 + 8~2 = 100
    //1~2 + 0~2 + 0~2 = 1
    public boolean isHappy(int n){
        if (n <= 0) return false;
        if (n == 1) return true;
        List<Integer> numList = new ArrayList<>();
        numList.add(n);
        while (n!=1) {
            int res = 0;
            char[] chars = String.valueOf(n).toCharArray();
            for (char c : chars) {
                res += (int)Math.pow(Integer.valueOf(c - '0'), 2);
            }
            if (res == 1){
                return true;
            }
            if (numList.contains(res)) return false;
            n = res;
        }
        return false;
    }


    //287. 寻找重复数
    // 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
    public int findDuplicate(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (numList.contains(temp)) return temp;
            numList.add(nums[i]);
        }
        return 0;
    }
    public int findDuplicate1(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (used[temp] == true) return temp;
            used[temp] = true;
        }
        return 0;
    }


    @Test
    void ResultTest() {
//        String content = "AAAAAA";
//        System.out.println(maxLen(content));
//        int[] nums = {2,1,1,2};
//        System.out.println(massage(nums));

        System.out.println(myAtoi("42"));
    }


}
