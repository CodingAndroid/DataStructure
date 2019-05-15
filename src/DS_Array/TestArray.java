package DS_Array;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 * desc: 封装数组--泛型数组
 */

public class TestArray<E> {

    private E data[]; //创建数组变量

    private int size; //数组实际大小

    /**
     * 有参构造函数
     * @param capacity  数组大小:最大容量
     */
    public TestArray(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数, 默认数组的容量capacity = 10
     */
    public TestArray(){
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
        for (int i = size - 1; i>=index; i--){ //从最后一个元素开始
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
        for (int i = 0;i < data.length; i++){
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
        for (int i=0;i < data.length; i++){
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
    public int findAll(int e){
        return 0;
    }

    /**
     * 根据索引删除元素, 返回删除的元素
     * @param index
     */
    public E remove(int index){
        if (index >= data.length)
            throw new IllegalArgumentException("Remove Failed.");
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove Failed.");
        E temp = data[index];
        for (int i = index; i < size; i++){
            data[i] = data[i+1]; //元素前移
        }
        size--;
        data[size] = null;// loitering objects != memory leak
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return temp;
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
    public void removeEle(E e){
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
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
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
