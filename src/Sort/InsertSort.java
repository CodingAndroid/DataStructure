package Sort;


/**
 * author: lihui1
 * date: 2019/4/11
 * email: 1316994947@qq.com
 * desc: 插入排序
 * 基本思想: 将未排序的数据直接插入到已经排好序序列的合适位置
 *      1.直接插入排序算法的时间复杂度为O(n*n)
 *      2.空间复杂度:O(1)
 *      3.稳定的
 */
public class InsertSort {

    public static void insertSort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
    }

    public static void main(String args[]){
        int a[] = {6, 5, 3, 8, 10, 2};
        insertSort(a);
    }
}
