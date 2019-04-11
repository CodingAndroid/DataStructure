package DataStructure_LinkedList;

import java.util.Stack;

/**
 * author: lihui1
 * date: 2019/2/16
 * email: 1316994947@qq.com
 * desc:单链表是一种常见的数据结构, 由一个个节点通过指针方式连接而成,
 * 每个节点由两部分组成: 一是数据域, 用于存储节点数据。二是指针域, 用于存储下一个节点的地址。
 * 链表-真正的动态数据结构
 * 优点: 真正的动态, 不需要处理固定容量的问题
 * 缺点: 丧失随机访问的能力, 增删快, 查询慢, 链表在计算机底层 内存地址不是连续的
 */

public class LinkedList<E> {

    /**
     * 定义节点
     */
    private class Node{

        public E e;//数据域

        public Node next;//指针域

        public Node(E e){
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;

    private int size;

    /**
     * 初始化链表
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 链表大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头部
     * @param e
     */
    public void addFirst(E e){
        Node node = new Node(e);//创建要插入的节点
        node.next = head;
        head = node;
        //head = new Node(e, head);
        size++;
    }

    /**
     * 在链表中间添加节点
     * @param index
     * @param e
     */
    public void addNode(int index, E e){
        if (index < 0 || index > size){
            return;
        }
        if (index == 0){
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            Node node = new Node(e);//创建要插入的节点
            node.next = prev.next;
            prev.next = node;
            //prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 在链表尾部添加节点
     * @param e
     */
    public void addLast(E e){
        addNode(getSize(), e);
    }

    /**
     * 链表删除
     * @param index
     */
    public void removeNode(int index){
        if (index < 0 || index >= size){
            return;
        }
        Node currentHead = head;
        if (index == 0){
            head = head.next;
        } else if (index == 1){
            currentHead.next = currentHead.next.next;
        } else {
            for (int i = 1; i < index; i++){
                currentHead = currentHead.next;
            }
            currentHead.next = currentHead.next.next;
        }
        size--;
    }

    /**
     * 非递归反转链表
     */
    public void reverseLinkedList(){
        Stack<Node> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        for (int i = 0; i < size; i++){
            if (i == size - 1){
                System.out.print(stack.pop().e);
            } else {
                System.out.print(stack.pop().e+"->");
            }
        }
        System.out.println();
    }

    /**
     * 递归方式反转链表
     * @param headNode
     */
    public void reverse(Node headNode){

        if(headNode!=null) {
            if(headNode.next!=null) {
                reverse(headNode.next);
            }
            System.out.print(headNode.e+"->");
        }
    }

    /**
     * 思路:
     * 所谓的单链表反转, 就是把每个节点的指针域由原来的指向下一个节点变为指向其前一个节点。
     * 但由于单链表没有指向前一个节点的指针域, 因此我们需要增加一个指向前一个节点的指针pre,
     * 用于存储每一个节点的前一个节点。此外,还需要定义一个保存当前节点的指针cur, 以及下一个
     * 节点的next。定义好这三个指针后, 遍历单链表,将当前节点的指针域指向前一个节点,之后将定
     * 义三个指针往后移动, 直至遍历到最后一个节点停止。
     * @param headNode
     */
    public void reverse1(Node headNode){
        if(headNode == null || headNode.next == null){
            return;
        }

        Node preNode = null;//前一个节点指针
        Node curNode = headNode;//当前节点指针
        Node nextNode = null;//下一个节点指针

        while (curNode != null){
            nextNode = curNode.next;//nextNode 指向下一个节点
            curNode.next = preNode;//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }
        Node top = preNode;
        while (top != null){
            System.out.print(top.next != null ? top.e+"->" : top.e);
            top = top.next;
        }
        System.out.println();
    }

    /**
     * 打印链表
     */
    public void showLinkedList(){
        Node top = head;
        while (top != null){
            System.out.print(top.next != null ? top.e+"->" : top.e);
            top = top.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        linkedList.addFirst(8);
        linkedList.addNode(3, 12);
        linkedList.addLast(10);
        linkedList.showLinkedList();
        linkedList.removeNode(0);
        linkedList.showLinkedList();
        //linkedList.reverseLinkedList();
        linkedList.reverse1(linkedList.head);
        System.out.println("链表size="+linkedList.size);
    }
}
