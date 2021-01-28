package com.lizhizhao.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class ListNodeTest {

    /**
     * 链表相关
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // region 234.回文链表
    /**
     * 链表数据放入数组在进行双指针比对
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> array = new ArrayList<>();
        while (head!=null) {
            array.add(head.val);
            head = head.next;
        }
        int i=0, len=array.size();
        int mid = len / 2;
        len--;
        while (i < mid) {
            if (array.get(i).intValue() != array.get(len).intValue()) {
                return false;
            }
            i++;
            len--;
        }
        return true;
    }

    /**
     * 递归反向迭代节点
     */
    ListNode fontNode;
    public boolean isPalindrome2(ListNode head) {
        fontNode = head;
        return checkEqual(head);
    }
    public boolean checkEqual(ListNode currentNode) {
        if (currentNode != null) {
            if (!checkEqual(currentNode.next)) return false;
            if (currentNode.val != fontNode.val) return false;
            fontNode = fontNode.next;
        }
        return true;
    }

    /**
     * 反转后半部分节点，然后与前半部分做对比
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode mid = findMidNode(head);
        ListNode revStart = revNode(mid.next);   // 后半段反转的首节点
        boolean result = true;
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = revStart;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        mid.next = revNode(revStart);
        return result;
    }
    private ListNode revNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // endregion

    @Test
    void ResultTest() {
//        String content = [1,2,2,3,3,null,null,4,4];


    }


}
