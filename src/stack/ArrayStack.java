package stack;

import java.util.Arrays;

/**
 * author: lihui1
 * date: 2019/1/14
 * email: 1316994947@qq.com
 * desc:
 */

class Person{

    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class ArrayStack {

    private int maxSize;

    public int top;

    public static Object[] stackArray;

    /**
     * 构造函数, 初始化操作
     * @param size
     */
    public ArrayStack(int size){
        stackArray = new Object[size];
        top = -1;
        maxSize = size;
    }

    /**
     * 入栈
     * @param obj
     * @return
     */
    public boolean push(Object obj){
        if (isFull()){
            return false;
        }
        stackArray[++top] = obj;
        return true;
    }

    public Object pop(){
        if (isEmpty()){
            return -1;
        }
        return stackArray[top--];
    }

    /**
     * 判断是否空栈
     * @return
     */
    public boolean isEmpty(){
        if (top <= -1){
            return true;
        }
        return false;
    }

    /**
     * 判断栈是否满
     * @return
     */
    public boolean isFull(){
        if (top>=maxSize-1){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        ArrayStack arrayStack = new ArrayStack(10);
        Person p = new Person(1, "java");
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push("hello");
        arrayStack.push(p);
        System.out.println(Arrays.toString(stackArray));
        System.out.println(arrayStack.top);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
