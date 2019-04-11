package queue;

/**
 * author: lihui1
 * date: 2018/7/24
 * email: 1316994947@qq.com
 * desc:
 */

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
