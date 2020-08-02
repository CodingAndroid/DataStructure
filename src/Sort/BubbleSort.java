package Sort;

import java.text.MessageFormat;
import java.util.Arrays;

import static Util.Utils.swap;

/**
 * author: lihui1
 * date: 2019/3/3
 * email: 1316994947@qq.com
 * desc: 冒泡排序
 * 1.基本思想: 比较相邻元素
 * 2.原理:
 *        2, 3, 5, 1, 0, 8, 6 //7个元素, 待排序
 *        2, 3, 1, 0, 5, 6, 8 //第一轮 6次
 *        2, 1, 0, 3, 5, 6    //第二轮 5次
 *        1, 0, 2, 3, 5       //第三轮 4次
 *        0, 1, 2, 3          //第四轮 3次
 *        0, 1, 2             //第五轮 2次
 *        0, 1                //第六轮 1次
 *
 * 3.优化:
 *
 * 4.稳定性: 稳定排序
 * 最好情况: 若初始序列已经排好序, 则需要1轮冒泡, 进行n-1次比较, 而不需要发生交换;
 * 最坏情况: 若初始序列逆序, 需要执行n-1冒泡, 而且每次都需要进行n-i-1次交换;
 * (n-1) + (n-2) + ... + 1 = n *(n-1) / 2;
 * 时间复杂度: 最坏:O(n*n), 最好: O(n), 平均: O(n*n);
 * 空间复杂度: 原地排序: O(1)
 */

public class BubbleSort {

    public static void bubbleSort(int nums[]){
        boolean hasChange;
        //外层控制轮数, 比较轮数 = 数组长度-1;
        for (int i = 0; i < nums.length-1; i++){
            //每次遍历标志位都要先置为false, 才能判断后面的元素是否发生了交换
            hasChange = false;
            //内层控制次数
            for (int j = 0; j < nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    hasChange = true;
                }
            }
            if (!hasChange){
                return;
            }
            System.out.println(MessageFormat.format("第{0}轮:", i) + Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 5, 1, 6, 8, 16};
        System.out.println("排序前:" + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
    }
}
