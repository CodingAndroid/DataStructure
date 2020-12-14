package LinkedList;

/**
 * 单链表是一种常见的数据结构, 由一个个节点通过指针方式连接而成,
 * 每个节点由两部分组成: 一是数据域, 用于存储节点数据。二是指针域, 用于存储下一个节点的地址。
 * 链表-真正的动态数据结构
 * 优点: 真正的动态, 不需要处理固定容量的问题
 * 缺点: 丧失随机访问的能力, 增删快, 查询慢, 链表在计算机底层内存地址不是连续的
 */
public class CommonLinkedList {

    private int size;
    public ListNode dummyHead;//虚拟头节点

    public CommonLinkedList(){
        size = 0;
        dummyHead = new ListNode();
    }

    public void addAtHead(int val){
        addAtIndex(0, val);
    }

    public void addAtTail(int val){
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val){
        if (index > size) return;
        if (index < 0)
            index = 0;
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = new ListNode(val);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) return;
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    public boolean delete(int value){
        return false;
    }

    public int get(int index){
        if (index < 0 || index >= size) return -1;
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void set(int index, int value){

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode node = dummyHead;
        while (node.next != null){
            node = node.next;
            builder.append(node.val).append("->");
        }
        builder.append("null");
        return "链表{" +
                "size=" + size +
                ", dummyHead=" + dummyHead.val +
                ",显示:" + builder.toString() +
                '}';
    }
}
