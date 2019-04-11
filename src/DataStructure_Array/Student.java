package DataStructure_Array;

/**
 * author: lihui1
 * date: 2018/7/24
 * email: 1316994947@qq.com
 * desc:
 */

public class Student {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, age : %d)", name, age);
    }

    public static void main(String[] args) {
        TestArray<Student> array = new TestArray<>();
        array.addLast(new Student("Java", 20));
        array.addLast(new Student("Jack", 30));
        array.addLast(new Student("Tom", 50));
        System.out.println(array);
    }
}
