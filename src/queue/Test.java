package Queue;

/**
 * author: lihui1
 * date: 2018/7/25
 * email: 1316994947@qq.com
 * desc:
 */

public class Test {

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
        arrayQueue.enqueue("java");
        arrayQueue.enqueue("c++");
        arrayQueue.enqueue("php");
        arrayQueue.enqueue("kotlin");
        arrayQueue.enqueue("node.js");
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}
