package BinaryTree;

/**
 * author: lihui1
 * date: 2019/11/10
 * email: 1316994947@qq.com
 * desc:
 */

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] array = {5, 3, 6, 8, 4, 2};
        for (int a : array) {
            bst.add(a);
        }
        System.out.println("");
        System.out.print("前序遍历(递归):");
        bst.preOrder(0);
        System.out.println("");
        System.out.print("中序遍历(递归):");
        bst.inOrder(0);
        System.out.println("");
        System.out.print("后序遍历(递归):");
        bst.postOrder(0);
        System.out.println("");
        System.out.print("前序遍历(非递归):");
        bst.preOrder(1);
        System.out.println("");
        System.out.print("后续遍历(非递归):");
        bst.postOrder(1);
        System.out.println("");
        System.out.print("层次遍历(队列):");
        bst.orderWidthFist();
        System.out.println("");
        System.out.print("层次遍历(非递归):");
        bst.orderWithFirstNR();
        System.out.println("");
        System.out.println("二叉树的高度:" + bst.getBSTHeight());
        System.out.println(bst.min());
    }
}
