package LinkedList;

public class Main {

    public static void main(String[] args) {
        CommonLinkedList linkedList = new CommonLinkedList();
        linkedList.addAtHead(10);
        linkedList.addAtTail(20);
        linkedList.addAtIndex(0, 5);
        linkedList.addAtIndex(1, 8);
        linkedList.deleteAtIndex(3);
        //System.out.println(linkedList.get(0));
        //System.out.println(linkedList);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addAtHead(1);
        singleLinkedList.addAtTail(3);
        singleLinkedList.addAtIndex(1,2);
        singleLinkedList.get(1);
        singleLinkedList.deleteAtIndex(1);
        singleLinkedList.get(1);
        System.out.println(singleLinkedList);
    }
}
