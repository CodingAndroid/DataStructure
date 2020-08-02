package Queue;

import Array.Array;

/**
 * author: lihui1
 * date: 2018/7/24
 * email: 1316994947@qq.com
 * desc:
 */

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<E>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<E>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append('[');
        for (int i = 0; i<array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
