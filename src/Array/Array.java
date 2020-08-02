package Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 * desc: 封装数组--泛型数组
 */

public class Array<E> {

    private E data[]; //创建数组变量

    private int size; //数组实际大小

    /**
     * 有参构造函数
     * @param capacity  数组大小:最大容量
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数, 默认数组的容量capacity = 10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取元素容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public E getFirst(){
        return data[0];
    }

    /**
     * 向数组末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 向数组头部添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 向指定位置(index)插入一个新元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed, Require index>=0 and index<=size.");
        if (size == data.length)
            //throw new IllegalArgumentException("Add Failed, Array is full.");
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--){ //从最后一个元素开始
            data[i+1] = data[i]; //后移
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E newData[] = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 根据索引查询元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed!");
        return data[index];
    }

    /**
     * 根据索引修改元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed!");
        data[index] = e;
    }

    /**
     * 数组是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0;i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;//循环结束后还未找到, 返回false;
    }

    /**
     * 搜索元素返回索引
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param e
     * @return
     */
    public Map<Integer, Object> findAll(E e){
        if (data == null) return null;
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                map.put(i, e);
            }
        }
        return map;
    }

    /**
     * 根据索引删除元素, 返回删除的元素
     * @param index
     */
    public E remove(int index){
        if (index >= data.length)
            throw new IndexOutOfBoundsException("index 不合法");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index 不合法");
        E e = data[index];
        for (int i = index; i < size; i++){
            data[i] = data[i+1]; //元素前移
        }
        size--;
        /**
         * 原来size位置是指向一个引用的, java中指向一个引用, 这个位置就不能被垃圾回收,
         * 如果我们把他置为null, 就会很快被垃圾回收了
         * loitering objects != memory leak 游荡对象不等于内存泄露
         * 游荡对象, 在我们程序中存在, 但是无法被垃圾回收处理
         */
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return e;
    }

    /**
     *
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     *
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 是否有元素e, 如果有删除
     * @param e
     */
    public void remove(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    /**
     *
     * @param e
     */
    public void removeAll(int e){

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d ", size, data.length));
        res.append('[');
        for (int i = 0; i<size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
