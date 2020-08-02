package Array;

/**
 * author: lihui1
 * date: 2018/7/1
 * email: 1316994947@qq.com
 * desc:
 */

public class Main {

    public static void main(String[] args) {
        int[] a = {100, 200, 210, 240};//静态创建
        int[] b = new int[]{1, 2, 3, 5, 8};//静态创建
        int[] c = new int[100];//动态创建
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < 10; i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        System.out.println(array.remove(10));
        System.out.println(array);
        System.out.println(a); //a变量在栈空间存储的值是该数组在堆中的地址;
        System.out.println(array.findAll(1));

        Array<Student> studentArray = new Array<Student>();
        studentArray.addFirst(new Student("Lily", 18));
        studentArray.add(1, new Student("Jack", 20));
        studentArray.addLast(new Student("Tom", 30));
        System.out.println(studentArray);
    }
}
