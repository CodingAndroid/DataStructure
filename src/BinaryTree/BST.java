package BinaryTree;

import java.util.*;

/**
 * author: lihui1
 * date: 2019/11/10
 * email: 1316994947@qq.com
 * desc: 二分搜索树 BinarySearchTree
 */

public class BST<E extends Comparable<E>> {

    /**
     * 定义节点
     */
    private class TreeNode {
        public TreeNode left;//左孩子

        public TreeNode right;//右孩子

        E e;//元素

        public TreeNode(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;

    private TreeNode root;//根节点

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 清空
     */
    public void clear(){

    }

    /**
     * 向二分搜索树添加新节点
     * @param e
     */
    public void add(E e){
        if (root == null){
            root = new TreeNode(e);
            size ++;
        } else {
            add(root, e);
        }
        //root = addE(root, e);
    }

    /**
     * 非递归
     * @param e
     */
    private void addFeiDiGui(E e){
        if (root == null){
            root = new TreeNode(e);
        }
    }

    /**
     * 向以node为根的二分搜索树插入元素e, 递归算法
     * @param node
     * @param e
     */
    private void add(TreeNode node, E e){
        if (e.equals(node.e)){
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null){
            node.left = new TreeNode(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new TreeNode(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);
    }

    /**
     * 优化
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private TreeNode addE(TreeNode node, E e){
        if (node == null){
            size++;
            return new TreeNode(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = addE(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = addE(node.right, e);
        }

        return node;
    }

    /**
     * 删除元素
     * @param e
     */
    public void remove(E e){

    }

    /**
     * 二分搜索树是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 以node为根的二分搜索树是否包含元素e, 递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(TreeNode node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    /**
     * 二分搜索树的前序遍历
     * @param type
     * 0 递归
     * 1 非递归
     */
    public void preOrder(int type){
        if (type == 0)
            preOrder(root);
        else
            preOrderNR(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     * @param node
     */
    private void preOrder(TreeNode node){
        if (node == null)
            return;
        System.out.print(node.e + " ");//1.访问根节点
        preOrder(node.left); //2.访问左子树
        preOrder(node.right); //3.访问右子树
    }

    /**
     * 前序遍历以node为根的二分搜索树, 非递归算法
     * 使用栈stack
     */
    private void preOrderNR(TreeNode node){
        if (node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();//当前访问的节点
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
            System.out.print(cur.e + " ");
        }
    }

    /**
     * 二分搜索树的中序遍历
     * 注意: 二分搜索树的中序遍历结果是顺序的
     * @param type
     * 0 递归
     * 1 非递归
     */
    public void inOrder(int type){
        if (type == 0)
            inOrder(root);
        else
            inOrderNR(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     * @param node
     */
    private void inOrder(TreeNode node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 非递归算法
     * @param node
     */
    private void inOrderNR(TreeNode node){
        if (node == null){
            return;
        }
    }

    /**
     * 二分搜索树的后序遍历
     * 应用: 为二分搜索树释放内存
     * @param type
     * 0 递归
     * 1 非递归
     */
    public void postOrder(int type){
        if (type == 0)
            postOrder(root);
        else
            postOrderNR1(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * @param node
     */
    private void postOrder(TreeNode node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    /**
     * 后序遍历以node为根的二分搜索树, 非递归算法
     * 2个栈
     * @param node
     */
    private void postOrderNR(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode cur = node;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(cur);
        while (!stack1.isEmpty()){
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null){
                stack1.push(cur.left);
            }
            if (cur.right != null){
                stack1.push(cur.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().e + " ");
        }
    }

    /**
     * 后序遍历以node为根的二分搜索树, 非递归算法
     * 1个栈
     * @param node
     */
    private void postOrderNR1(TreeNode node){
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curVisitNode = node; //当前访问的结点
        TreeNode lastVisitNode = null; //上次访问的结点
        //把currentNode移到左子树的最下边
        while (curVisitNode != null){
            stack.push(curVisitNode);
            curVisitNode = curVisitNode.left;
        }

        while (!stack.isEmpty()){
            curVisitNode = stack.pop(); //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (curVisitNode.right != null && curVisitNode.right != lastVisitNode){
                //根节点再次入栈
                stack.push(curVisitNode);
                //进入右子树, 且可肯定右子树一定不为空
                curVisitNode = curVisitNode.right;
                while (curVisitNode != null){
                    //再走到右子树的最左边
                    stack.push(curVisitNode);
                    curVisitNode = curVisitNode.right;
                }
            } else {
                //访问
                System.out.print(curVisitNode.e + " ");
                //修改最近被访问的节点
                lastVisitNode = curVisitNode;
            }
        }
    }

    /**
     * 广度优先遍历(层次遍历): 非递归算法 使用队列
     */
    public void orderWidthFist(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//根节点入队
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.e + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public void orderWithFirstNR(){

    }

    private List<List<E>> levelOrder(TreeNode root){
        if (root == null)
            return null;
        List<List<E>> res = new LinkedList<>();
        
        return res;
    }

    public int getBSTHeight(){
        return getBSTHeightNR();//getBSTHeight(root);
    }

    /**
     * 获取二分搜索树的高度 递归
     * @param treeNode
     * @return
     */
    private int getBSTHeight(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        return Math.max(getBSTHeight(treeNode.left), getBSTHeight(treeNode.right)) + 1;
    }

    /**
     * 获取二分搜索树的高度 非递归
     * @return
     */
    private int getBSTHeightNR(){
        if (root == null){
            return 0;
        }

        int height = 0;
        int levelSize = 1;//每一层元素数量
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);//根节点入队
        while (!nodeQueue.isEmpty()){
            TreeNode cur = nodeQueue.poll();
            levelSize--;
            if (cur.left != null){
                nodeQueue.offer(cur.left);
            }
            if (cur.right != null){
                nodeQueue.offer(cur.right);
            }
            if (levelSize == 0){
                levelSize = nodeQueue.size();
                height++;
            }
        }
        return height;
    }

    public E min(){
        if (size == 0)
            throw new IllegalArgumentException("tree is empty");
        return min(root).e;
    }

    private TreeNode min(TreeNode treeNode){
        if (treeNode.left == null)
            return treeNode;
        return min(treeNode.left);
    }

    /**
     * 生成以node为根节点, 深度为depth的描述二分搜索树的字符串
     * @param node
     * @param depth
     * @param stringBuilder
     */
    private void generateBSTString(TreeNode node, int depth, StringBuilder stringBuilder){
        if (node == null){
            stringBuilder.append( generateDepthString(depth)+ "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, stringBuilder);
        generateBSTString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }
}
