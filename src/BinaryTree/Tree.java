package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 1.定义: 二叉树(binary tree)是结点的有限集合, 这个集合或者空, 或者由一个根及两个互不相交的称为这个根的左子树或右子树构成.
 * 2.特点:
 * 3.遍历顺序:
 *          前序遍历：按照“根左右”,先遍历根节点，再遍历左子树 ，再遍历右子树
 *          中序遍历：按照“左根右“,先遍历左子树，再遍历根节点，最后遍历右子树
 *          后序遍历：按照“左右根”，先遍历左子树，再遍历右子树，最后遍历根节点
 */
public class Tree {
    
    private Node root; //根结点
    private List<Node> list = new ArrayList<Node>();
    
    public Tree(){
        init();
    }

    private void init() {
        Node x=new Node("X",null,null);
        Node y=new Node("Y",null,null);
        Node d=new Node("d",x,y);
        Node e=new Node("e",null,null);
        Node f=new Node("f",null,null);
        Node c=new Node("c",e,f);
        Node b=new Node("b",d,null);
        Node a=new Node("a",b,c);
        root =a;
    }

    /**
     * 定义结点类
     */
    private class Node{

        private String data;//保存数据

        private Node lchid;//定义指向左子树的指针

        private Node rchild;//定义指向右子树的指针

        public Node(String data, Node lchild, Node rchild){
            this.data=data;
            this.lchid=lchild;
            this.rchild=rchild;
        }
    }


    /**
     * 对该二叉树进行前序遍历 结果存储到list中 前序遍历:ABDXYCEF
     */
    public void preOrder(Node node) {

        list.add(node); //先将根节点存入list
        //如果左子树不为空继续往左找，在递归调用方法的时候一直会将子树的根存入list，这就做到了先遍历根节点
        if(node.lchid != null)
        {
            preOrder(node.lchid);
        }
        //无论走到哪一层，只要当前节点左子树为空，那么就可以在右子树上遍历，保证了根左右的遍历顺序
        if(node.rchild != null)
        {
            preOrder(node.rchild);
        }
    }

    /**
     * 对该二叉树进行中序遍历 结果存储到list中
     */
    public void inOrder(Node node) {
        if(node.lchid!=null){
            inOrder(node.lchid);
        }
        list.add(node);
        if(node.rchild!=null){
            inOrder(node.rchild);
        }
    }

    /**
     * 对该二叉树进行后序遍历 结果存储到list中
     */
    public void postOrder(Node node) {
        if(node.lchid!=null){
            postOrder(node.lchid);
        }
        if(node.rchild!=null){
            postOrder(node.rchild);
        }
        list.add(node);
    }

    public int getTreeDepth(Node node) {

        if (root.data == null){
            return 0;
        }
        if(node.lchid == null && node.rchild == null) {
            return 1;
        }
        int left=0,right = 0;
        if(node.lchid!=null) {
            left = getTreeDepth(node.lchid);
        }
        if(node.rchild!=null) {
            right = getTreeDepth(node.rchild);
        }
        return left>right?left+1:right+1;
    }

    public boolean isEmpty(){
        return root.data == null;
    }

    /**
     * 递归反转二叉树
     * @param root
     */
    public void reverseTree(Node root){

        list.add(root);

        if (root.lchid == null && root.rchild == null){
            return;
        }

        if (root.lchid != null && root.rchild != null){
            Node temp;
            temp = root.lchid;
            root.lchid = root.rchild;
            root.rchild = temp;
        }

        if (root.lchid != null){
            reverseTree(root.lchid);
        }

        if (root.rchild != null){
            reverseTree(root.rchild);
        }
    }

    /**
     * 非递归反转二叉树
     * @param root
     */
    public void invertTree(Node root){

    }


    //得到遍历结果
    public List<Node> getResult() {
        return list;
    }

    public static void main(String args[]){
        Tree tree=new Tree();
        System.out.println("根节点是:"+tree.root.data);
        System.out.println("树的深度是:"+tree.getTreeDepth(tree.root));
        //System.out.print("后序遍历结果:");
        //tree.postOrder(tree.root);
        tree.reverseTree(tree.root);
        for(Node node:tree.getResult()){
            System.out.print(node.data+" ");
        }
    }

}
