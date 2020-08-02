package Sort;

import Util.Utils;

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

        if (a == null || a.length == 0 || a.length == 1){
            return;
        }

        if (low < high){
            int p = partition2(a, low, high);
            sort(a, low, p - 1);
            sort(a, p + 1, high);
        }

    }

    /**
     * 左右指针
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(int a[], int low, int high){

        int i = low + 1; //左指针
        int j = high; //右指针
        int pivot = a[low]; //取第一个元素作为主元;

        while (i <= j){
            while (i <= j && a[i] <= pivot) i++;

            while (i <= j && a[j] > pivot) j--;

            if (i < j){
                Utils.swap1(a, i, j);
            }
        }
        Utils.swap1(a, low, j); //主元和j位置元素交换
        return j;
    }

    /**
     * 前后指针
     * 思想:
     * https://www.cnblogs.com/Unicron/p/9465403.html
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int partition2(int[] nums, int low, int high){
        int pivot = nums[low];
        int j = low+1;
        int i = low;
        while (j <= high && i < j){
            if (nums[j] < pivot){
                i++;
                if (i != j){
                    Utils.swap(nums, i, j);
                }
            }
            j++;
        }
        Utils.swap(nums, low, i);
        return i;
    }

    /**
     * 前后指针-选择最后一个元素作为基准
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int partition3(int[] nums, int low, int high){

        int pivot = nums[high];
        int cur = low;
        int pre = cur - 1;

        while (cur <= high){
            if (nums[cur] <= pivot){
                pre++;
                if (cur != pre){
                    Utils.swap(nums, pre, cur);
                }
            }
            cur++;
        }
        return pre;
    }

    public static void main(String args[]){
        int a[] = {49, 38, 65, 97, 76, 13, 27};
        //int[] a = {4,3,1,5,2};
        //对整个数据源进行快速排序
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
