package DataStructure_Sort;

import java.util.Arrays;

/**
 * author: lihui1
 * date: 2019/4/11
 * email: 1316994947@qq.com
 * desc: 快速排序
 */

public class QuickSort {

    /**
     * 排序分治
     * @param a
     * @param low
     * @param high
     */
    public static void sort(int a[], int low, int high){
        int i, j, index;
        if (low > high){
            return;
        }

        i = low;
        j = high;
        index = a[i];//表的第一个元素作为基准
        while (i<j){//从表的两端交替向中间进行扫描
            while (i < j && a[j] >= index){
                j--;
            }

            if (a[j] < index){
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < index){
                i++;
            }

            if (a[i] > index){
                a[j] = a[i];
                j--;
            }
        }

        a[i] = index;
        int k = i;
        if (k > low)
            sort(a, low, i-1);
        if (k < high)
            sort(a, i+1, high);
    }


    public static void main(String args[]){
        int a[] = {49, 38, 65, 97, 76, 13, 27};
        //对整个数据源进行快速排序
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
