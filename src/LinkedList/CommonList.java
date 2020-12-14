package LinkedList;

/**
 * 作者: lihui1
 * 日期: 2020/12/13 4:10 下午
 * 描述:
 */
public interface CommonList<E> {

    boolean isEmpty();

    int size();

    E get(int index);

    boolean add(E e);

    void add(int index, E e);

    boolean contains(Object o);

    boolean remove(Object o);

    E remove(int index);

    int indexOf(Object o);
}
