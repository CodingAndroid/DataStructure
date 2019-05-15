package DS_Array;

/**
 * author: lihui1
 * date: 2018/7/27
 * email: 1316994947@qq.com
 * desc:
 * 题目:输入一个矩阵, 按照从外向里以顺时针的顺序依次打印每一个数字. 例如输入：
 *      {{1，2，3},
 *      {4，5，6},
 *      {7，8，9}}
 *      则依次打印数字为 1、2、3、6、9、8、7、4、5
 */

public class PrintArray {

    public static void printArray(int nums[][]){

        if(nums == null){
            return;
        }

        int rows = nums.length; //行数
        int colums = nums[0].length; //列数

    }

    public static void main(String[] args) {

        int nums[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(nums);
    }
}
