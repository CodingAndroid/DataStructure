package DS_Array;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 * desc:
 */

public class Main {

    public static void main(String[] args) {
        int a[] = {100, 200, 210, 240};//静态创建
        int b[] = new int[]{1, 2, 3, 5, 8};//静态创建
        int c[] = new int[100];//动态创建
        TestArray array = new TestArray();
        for (int i = 0; i < 10; i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        System.out.println(array.remove(1));
        System.out.println(array);
        System.out.println(a); //a变量在栈空间存储的值是该数组在堆中的地址;
    }
}
