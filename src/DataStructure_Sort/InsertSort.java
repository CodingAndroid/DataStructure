package DataStructure_Sort;

import java.util.Arrays;


/**
 * 1.算法思想:将未排序的数据直接插入到已经排好序序列的合适位置
 * 2.直接插入排序算法的时间复杂度为O(n*n)
 * 3.空间复杂度:O(1)
 * 4.稳定的
 */
public class InsertSort {

    public static void insertSort(int[] a){
        int length=a.length;//数组长度，将这个提取出来是为了提高速度。
        for(int i=1;i<length;i++){//插入的次数
            int insertNum = a[i];//待插入的数
            int j;//已经排序好的序列元素个数
            for (j = i-1; j>=0; j--){
                //判断是否大于insertNum, 大于则后移一位
                if (a[j] > insertNum){
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1]=insertNum;//将需要插入的数放在要插入的位置。
            System.out.println(i + ":" + Arrays.toString(a));
        }
    }

    public static void main(String args[]){
        int a[] = {6, 5, 3, 8, 10, 2};
        insertSort(a);
    }
}
