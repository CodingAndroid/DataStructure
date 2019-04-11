package LinearList;

public class LinkedListDemo {

    //指向头指针的引用
    private Node head;

    //线性表的大小
    private int size;

    public LinkedListDemo(){
        head = new Node();
    }

    public LinkedListDemo(Object data) {
        head = new Node(data);
    }

    /**
     * 结点类
     */
    public static class Node{
        //数据域
        private Object data;

        //指向后继结点的引用;
        private Node next;

        Node(){

        }

        Node(Object data){
            this(data, null);
        }

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头插法
     * 步骤1: 新结点的next链指向当前头结点;
     * 步骤2: 将head指向新节点
     * 时间复杂度: O(1)
     * @param data
     */
    public void insertHead(Object data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * 尾插法
     * @param data
     */
    public void insertLast(Object data){
        Node newNode = new Node(data);
        Node tail = head;
        if (head.next == null){
            head.next = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 从头部进行删除操作
     * 步骤:1.将头结点的next链置空
     * 步骤:2.将head引用指向第二个结点
     * 时间复杂度为: O(1)
     * @return
     */
    public boolean deleteHead(){
        if (isEmpty()){
            return false;
        }

        Node secondNode =  head.next;
        head.next = null;
        head = secondNode;
        size--;
        return true;
    }

    /**
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        if (!checkIndex(index)) {
            try {
                throw new Exception("err");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Node curr = head;
        for (int i = 0; i<index;i++){
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     *
     * @param i
     * @param x
     * @throws Exception
     */
    public void insert(int i, Object x) throws Exception{
        if (i<0)
            System.out.println("---");
        else {
            Node temp = new Node(x);
            if (i==1){
                temp.next = head;
                head = temp;
            } else {
                Node current = head;
                int currLength = 0;
                while (current.next!=null){
                    currLength++;
                    if (currLength==i-1){
                        temp.next = current.next;
                        current.next = temp;
                    }
                    current = current.next;
                }
                if (i>currLength)
                    System.out.println(currLength+"lll"+i);
            }

        }
    }

    /**
     * 遍历链表
     * 时间复杂度: O(n)
     */
    public void displayList(){
        Node top = head;
        while (top!=null){
            System.out.print(top.data+" ");
            top = top.next;
        }
        System.out.println();
    }

    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
    public static void main(String args[]) throws Exception{
        LinkedListDemo listDemo = new LinkedListDemo("");
//        listDemo.insertHead("a");
//        listDemo.insertHead("b");
//        listDemo.insertHead("c");
//        listDemo.insertHead("d");
//        listDemo.insertHead("e");
//        listDemo.insertHead("f");
//        listDemo.insertHead("g");
//        listDemo.insertHead("h");
        listDemo.insertLast("1");
        listDemo.insertLast('2');
        listDemo.insertLast("3");
        listDemo.displayList();
    }
}
