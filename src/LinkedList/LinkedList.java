package LinkedList;

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

        public Node next;//指针域, 指向后继结点的引用

        public Node(){
            this(null, null);
        }

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

    private Node dummyHead;//虚拟头结点
    /**
     * 为何引入虚拟头节点
     *
     */

    private int size;

    /**
     * 初始化链表
     */
    public LinkedList() {
        dummyHead = new Node(null, null);//null-> 1-> 2-> 3-> 4-> NULL
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
     * 在链表中间添加节点
     * @param index
     * @param e
     */
    public void addNode(int index, E e){
        if (index < 0 || index > size){
            return;
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node node = new Node(e);//创建要插入的节点
        node.next = prev.next;
        prev.next = node;
        //prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头部
     * @param e
     */
    public void addFirst(E e){
        addNode(0, e);
    }

    /**
     * 在链表尾部添加节点
     * @param e
     */
    public void addLast(E e){
        addNode(size, e);
    }


    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set Failed");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
         Node cur = dummyHead.next;
         while (cur != null){
             if (cur.e.equals(e))
                 return true;
             cur = cur.next;
         }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            builder.append(cur).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

    /**
     * 删除索引为index的元素
     * @param index
     */
    public boolean remove(Integer index){
        if (index == null || index < 0 || index >= size){
            return false;
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
        return true;
    }

    /**
     * 删除元素e
     * @param e
     * @return
     */
    public boolean remove(E e){
        Node pre = dummyHead;
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e == e){
                pre.next = cur.next;
                size--;
                return true;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Character> linkedList = new LinkedList<Character>();
        linkedList.addFirst('a');
        linkedList.addLast('b');
        linkedList.addLast('c');
        linkedList.addLast('e');
        linkedList.addLast('f');
        linkedList.addNode(3, 'd');
        linkedList.addLast('g');
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.remove('f');
        System.out.println(linkedList);
        System.out.println("链表size="+linkedList.size);
    }
}
