package Stack;

/**
 * author: lihui1
 * date: 2019/6/1
 * email: 1316994947@qq.com
 * desc:
 */

public interface IStack<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();
}
