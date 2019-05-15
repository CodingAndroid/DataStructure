package DS_Sort;

import java.util.Arrays;


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

    public static void insertSort(int[] a){
        if (a == null || a.length == 0){
            return;
        }

        int length = a.length;//数组长度，将这个提取出来是为了提高速度
        int insertNum;
        for (int i = 1; i < length; i++){ //插入的次数
            insertNum = a[i]; //待插入的元素;
            int j;//已排序元素的个数;
            for (j = i-1; j>=0; j--){
                if (insertNum >= a[j]){
                    break;
                } else {
                    a[j+1] = a[j];//判断是否大于insertNum, 大于则后移一位
                }
            }
            a[j+1] = insertNum; //将需要插入的数放在要插入的位置
            System.out.println(i + ":" + Arrays.toString(a));
        }
    }

    public static void main(String args[]){
        int a[] = {6, 5, 3, 8, 10, 2};
        insertSort(a);
    }
}
