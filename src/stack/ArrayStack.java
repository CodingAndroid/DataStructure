package Stack;

/**
 * author: lihui1
 * date: 2019/1/14
 * email: 1316994947@qq.com
 * desc: 栈 先进后出
 */

public class ArrayStack<T> implements IStack<T> {

    private int maxSize;

    public int top;//栈顶元素的索引

    public T[] stackArray;

    /**
     * 构造函数, 初始化操作
     * @param capacity
     */
    public ArrayStack(int capacity){
        stackArray = (T[]) new Object[capacity];
        top = -1;
        maxSize = capacity;
    }

    /**
     * 入栈
     * @param t
     */
    @Override
    public void push(T t){
        if (isFull()){
            return;
        }
        stackArray[++top] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            return null;
        }
        return (T) stackArray[top--];
    }

    @Override
    public T peek() {
        return stackArray[top];
    }

    /**
     * 判断是否空栈
     * @return
     */
    @Override
    public boolean isEmpty(){
        return top <= -1;
    }

    @Override
    public int getSize() {
        return top + 1;
    }

    /**
     * 判断栈是否满
     * @return
     */
    @Override
    public boolean isFull(){
        return top >= maxSize - 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (stackArray != null && top > 0){
            for (int i = 0; i <= top; i++) {
                if (stackArray[i] == null) {
                    builder.append("]");
                    return builder.toString();
                }
                if (i < top)
                    builder.append(stackArray[i]).append(",");
                else
                    builder.append(stackArray[i]);
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args){
        ArrayStack<Object> arrayStack = new ArrayStack<>(10);
        Person p = new Person(1, "java");
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push("hello");
        arrayStack.push(p);
        System.out.println(arrayStack);

        System.out.print(arrayStack.pop());
        System.out.println(arrayStack);

        System.out.print(arrayStack.peek());
        System.out.println(arrayStack);
    }
}
