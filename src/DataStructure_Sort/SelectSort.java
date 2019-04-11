package DataStructure_Sort;

import queue.Array;

import java.util.Arrays;

/**
 * author: lihui1
 * date: 2019/4/11
 * email: 1316994947@qq.com
 * desc: 选择排序
 * 原理: 每一趟从待排序的记录中选出最小的元素, 顺序放在已排好序的序列最后, 直到全部记录排序完毕。
 * 也就是: 每一趟在n-i+1(i=1, 2, ...n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
 * 基本思想:给定含有n个元素的数组int array[];
 *        第一趟排序, 在待排序元素array[0]-array[n-1]中选出最小的元素e, 将e与array[0]交换位置;
 *        第二趟排序, 在待排序元素array[1]-array[n-1]中选出最小的元素e, 将e与array[1]交换位置;
 *        以此类推....., 第i趟在待排序元素array[i]-array[n-1]中选出最小的元素e, 将e与array[i]交换位置, 直至全部排序完成。
 */

public class SelectSort {

    public static void selectSort(int a[]){
        if (a == null || a.length == 0){
            return;
        }
        int length = a.length;
        int min = 0;
        for (int i = 0; i < length-1; i++){
            min = a[i];
            int position = i;
            for (int j = i+1; j < length; j++){
                if (min > a[j]){
                    min = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = min;
            System.out.println(i+Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int num[] = {4, 5, 6, 3, 2, 1, 10, 9};
        selectSort(num);
    }
}
