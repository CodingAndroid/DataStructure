package LinkedList;

public class LinkedList01<E> {

    /**
     * 定义节点
     */
    private class Node{

        E e; //数据域
        Node next;//指针域, 指向下一个节点, 保存下一个节点的内存地址

        public Node(){
            this(null, null);
        }

        public Node(E e){
            this(e, null);
        }

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
    }

    private int size;

    private Node head;

    public LinkedList01(){
        head = null; //1-> 2-> 3-> 4-> NULL
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 头插法
     * @param e
     */
    public void addFirst(E e){
        Node node = new Node(e);//待插入的节点
        node.next = head;
        head = node;
        //以上3行 等价于 head = new Node(e, head);
        size++;
    }

    /**
     * 尾插法
     * 每插入一个元素都要对节点进行判空,
     * 头节点与其他节点插入逻辑不一致
     * @param e
     */
    public void addLast(E e){
       Node node = new Node(e);
       if (head == null){
           node.next = head;
           head = node;
           size++;
           return;
       }
       Node pre = head;
       while (pre.next != null){
           pre = pre.next;
       }
       pre.next = node;
       size++;
    }

    /**
     * 在链表的index位置添加新的元素e
     * @param e
     * @param index
     */
    public void add(E e, int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Illegal index");
        }
        if (index == 0){
            addFirst(e);
        } else{
            Node pre = head;
            //找到待插入节点的前驱节点
            for (int i = 1; i < index; i++){
                pre = pre.next;
            }
            Node node = new Node(e);//待插入的元素e
            node.next = pre.next;
            pre.next = node;
            //以上3行 等价于  pre.next = new Node(e, pre.next);
        }
        size++;
    }

    /**
     * 删除元素e
     * @param e
     */
    private boolean remove(E e){
        if (head == null){
            return false;
        }
        if (head.e == e){
            head = head.next;
            return true;
        }
        Node pre = head;
        while (pre.next != null){
            if (pre.next.e == e){
                pre.next = pre.next.next;
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    /**
     * 获取索引为index的元素
     * @param index
     * @return
     */
    private E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index is not exist");
        Node pre = head;
        for (int i  = 0; i < index; i++){
            pre = pre.next;
        }
        return pre.e;
    }

    /**
     * 是否包含元素e
     * @param e
     * @return
     */
    private boolean contains(E e){
        if (head == null)
            return false;
        Node pre = head;
        while (pre != null){
            if (pre.e == e){
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = head;
        while (cur != null){
            builder.append(cur.e).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList01<Integer> linkedList01 = new LinkedList01<Integer>();
        linkedList01.addFirst(1);
        linkedList01.addFirst(2);
        linkedList01.addLast(3);
        linkedList01.add(5, 1);
        linkedList01.add(6, 3);
        linkedList01.add(8, 5);
        linkedList01.add(10, linkedList01.size);
        System.out.println("size = " + linkedList01.size);
        System.out.println("链表:" + linkedList01);
        System.out.println("索引为6的元素:" + linkedList01.get(6));
        System.out.println("是否包含元素8:" + linkedList01.contains(8));
        System.out.println("删除元素12生成的链表:" + linkedList01.remove(12) + " " + linkedList01);
    }
}
