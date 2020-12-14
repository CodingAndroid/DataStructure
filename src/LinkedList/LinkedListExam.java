package LinkedList;

public class LinkedListExam {

    /**
     * 206. 链表反转
     * 反转一个单链表。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;//防止链表循环
        return cur;
    }

    public ListNode reverseNR(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextNode;
        while (cur != null){
            nextNode = cur.next;//获取当前节点的下一个节点;
            cur.next = pre; //当前节点指向pre
            pre = cur; //pre、cur前移
            cur = nextNode;
        }
        return pre;
    }

    public ListNode reverseNRII(ListNode head){
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = head;
        ListNode next = head;

        ListNode node = new ListNode(head.val);

        while (cur.next != null){
            pre = cur.next;
            next = pre.next;

            cur.next = next;
            pre.next = cur;
            pre = node;
        }
        return node;
    }

    /**
     * 92. 反转链表 II
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseII(ListNode head, int m, int n){
        return null;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementNR(ListNode head, int val){
        while (head != null && head.val == val){
            ListNode del = head;
            head = head.next;
            del.next = null;
        }
        if (head == null) return null;
        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val){
                ListNode del = pre.next;
                pre.next = del.next;
                del.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }


    public ListNode removeElementNRII(ListNode head, int val){
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1); //设置虚拟头结点
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode removeElement(ListNode head, int val){
        if (head == null) {
            return null;
        }
        //删除head后面值为val的元素
        ListNode res = removeElement(head.next, val);
        //head节点是要删除的节点
        if (head.val == val){
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead; //前驱节点
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;//向前移动一步
        }
        if (l1 != null){
            pre.next = l1;
        }
        if (l2 != null){
            pre.next = l2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        ListNode head1 = new ListNode(1);
        ListNode a1 = new ListNode(3);
        ListNode b1 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode d1 = new ListNode(8);
        head1.next = a1;
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        LinkedListExam exam = new LinkedListExam();
        ListNode node = exam.mergeTwoLists(head, head1);
        while (node != null){
            if (node.next != null){
                System.out.print(node.val + "->");
            } else {
                System.out.print(node.val + "" );
            }
            node = node.next;
        }
    }
}
