package Sort;

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

    public static void selectSort(int nums[]){
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int minIndex;
        for (int i = 0; i < nums.length; i++){
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int num[], int i, int j){
        //int temp = num[i];
        //num[i] = num[j];
        //num[j] = temp;
        if (i == j){ //一定要判断
            return;
        }
        num[i] = num[i] ^ num[j];
        num[j] = num[i] ^ num[j];
        num[i] = num[i] ^ num[j];
    }

    public static void main(String[] args) {
        int num[] = {4, 5, 6, 3, 2, 1, 10, 9};
        selectSort(num);
        for (int i: num) {
            System.out.print(i + " ");
        }
    }
}
