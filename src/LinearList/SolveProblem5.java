package LinearList;

import java.util.Stack;

public class SolveProblem5 {

    //非递归的方式，鲁棒性好
    public static void printListReverse(listNode headNode){
        Stack<listNode> stack=new Stack<listNode>();
        while(headNode!=null)
        {
            stack.push(headNode);
            headNode=headNode.next;
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop().data);
        }

    }

    //递归方式，递归在本质上就是一个栈结构
    public static void printListReverse_recursively(listNode headNode){
        if(headNode!=null)
        {
            if(headNode.next!=null)
            {
                printListReverse_recursively(headNode.next);
            }
            System.out.println(headNode.data);

        }
    }



    public static void main(String[] args) {
        listNode node1=new listNode();
        listNode node2=new listNode();
        listNode node3=new listNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;
        SolveProblem5 sp5=new SolveProblem5();
        sp5.printListReverse(node1);
        sp5.printListReverse_recursively(node1);
    }
}
class listNode{
    int data;
    listNode next;
}
