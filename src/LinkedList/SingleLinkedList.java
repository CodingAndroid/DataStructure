package LinkedList;

/**
 * 单链表
 *
 */
public class SingleLinkedList {

    private int size;

    private ListNode head;

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 在链表头部添加一个值为value的节点。
     * 插入后, 新节点将成为链表的第一个节点。
     * 时间复杂度: O(1)
     * @param value
     */
    public void addAtHead(int value){
        ListNode node = new ListNode(value);//待插入的节点
        node.next = head;
        head = node; //head指向新的节点
        //head = new ListNode(e, head);
        size++;
    }

    /**
     * 将值为value的节点追加到链表的最后一个元素。
     * @param value
     */
    public void addAtTail(int value){
        ListNode node = new ListNode(value);
        ListNode pre = head;
        if (pre != null){
            while (pre.next != null){
                pre = pre.next;
            }
            node.next = null;
            pre.next = node;
        } else {
            node.next = null;
            head = node;
        }
        size++;
    }

    /**
     * 在链表中的第index个节点之前添加值为value的节点。如果index等于链表的长度,
     * 则该节点将附加到链表的末尾。如果index大于链表长度, 则不会插入节点。
     * 如果index小于0, 则在头部插入节点。
     * @param index
     * @param value
     */
    public void addAtIndex(int index, int value){
        if (index > size) return;
        if (index <= 0){
            addAtHead(value);
        } else if (index == size){
            addAtTail(value);
        } else {
            ListNode node = new ListNode(value);
            ListNode pre = head;
            for (int i = 0; i < index - 1; i++){
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    /**
     *
     * @param index
     * @return
     */
    public int get(int index){
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 如果索引index有效, 则删除链表中的第index个节点。
     * @param index
     * @return
     */
    public void deleteAtIndex(int index){
        if (index < 0 || index >= size)
            return;
        if (index == 0){
            head = head.next;
            size--;
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index - 1; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean delete(int value){
        if (head == null) return false;
        if (head.val == value){
            head = head.next;
            return true;
        }
        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == value){
                ListNode del = pre.next;
                pre.next = del.next;
                size--;
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean contains(int value){
        if (head == null) return false;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = head;
        while (cur != null){
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
