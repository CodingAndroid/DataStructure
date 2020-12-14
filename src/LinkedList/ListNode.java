package LinkedList;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 *
 * 定义链表节点
 * value: 是当前节点的值
 * next: 是指向下一个节点的指针/引用
 *
 */

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(){
        this(0, null);
    }

    public ListNode(int val){
        this(val, null);
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
