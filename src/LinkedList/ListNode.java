package LinkedList;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 */

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x){
        this.val = x;
    }

    /**
     * 203 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public static ListNode remove(ListNode head, int val){

        while (head != null && head.val == val){
            ListNode delNode = head; //要删除的结点
            head = head.next;
            delNode.next = null;
        }

        if (head == null || head.next == null){ //注意边界条件
            return head;
        }

        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val){
                ListNode delNode = pre.next; //要删除的结点
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    /**
     * 237 删除链表中的节点
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 说明: 链表至少包含两个节点。
     *      链表中所有节点的值都是唯一的。
     *      给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     *      不要从你的函数中返回任何结果。
     * 思路: 将node下个节点的值赋值到node上, 然后跳过node的下一个节点
     * @param node
     * @return
     */
    public static void removeNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 83 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1.next != null){
            if (node2.val == node1.val){
                if (node2.next == null){
                    node1.next = null;
                } else {
                    node2.val = node2.next.val;
                    node2.next = node2.next.next;
                }
            } else {
                node1 = node1.next;
                if (node2.next != null){
                    node2 = node2.next;
                }
            }


        }
        return head;
    }

    /**
     * 82 删除排序链表中的重复元素 II 难度 中等
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     *
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 思路: 2指针
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode dumy = new ListNode(0);//虚拟结点
        dumy.next = head;
        //两指针
        ListNode preNode = dumy;
        while (preNode.next != null){
            ListNode curNode = preNode.next;
            //不能用if 因为出现[2->2->2->3] 必须遍历到最后, 因此使用while
            while (curNode.next != null && curNode.val == curNode.next.val){
                curNode = curNode.next;
            }
            if (curNode != preNode.next){
                preNode.next = curNode.next;
            } else {
                preNode = preNode.next;
            }
        }
        return dumy.next;
    }

    /**
     * 876 链表的中间结点 难度 简单
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 思路: 快、慢指针
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode p = head;//慢指针
        ListNode q = head;//快指针
        while (q.next != null){
            p = p.next;
            if (q.next.next != null){
                q = q.next.next;
            } else {
                q = q.next;
            }
        }
        return p;
    }

    /**
     * 21 合并两个有序链表 难度 简单
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        } else if (l1 == null && l2 == null){
            return null;
        }

        ListNode dumyHead = new ListNode(0);//定义一个虚拟结点, 作为新链表的头结点
        ListNode cur = dumyHead;//设置一个当前指针 指向新链表头结点
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
            if (l1 == null){
                cur.next = l2;
            } else {
                cur.next = l1;
            }
        }
        return dumyHead.next;
    }

    /**
     * 递归求解
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p = null;

        if (l1.val < l2.val){
            p = l1;
            p.next = mergeTwoLists2(l1.next, l2);
        } else {
            p = l2;
            p.next = mergeTwoLists2(l1, l2.next);
        }

        return p;
    }
    /**
     * 148 排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        root.next = b;
        b.next = c;

        ListNode root2 = new ListNode(1);
        ListNode p = new ListNode(2);
        ListNode q = new ListNode(3);
        root2.next = p;
        p.next = q;

        ListNode node = mergeTwoLists2(root, root2);

        while (node != null){
            if (node.next != null){
                System.out.printf(node.val + "->");
            } else {
                System.out.printf(node.val+"");
            }
            node = node.next;
        }
    }
}
