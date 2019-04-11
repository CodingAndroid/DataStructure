package DataStructure_Sort;

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
 * 4.稳定性: 稳定排序
 * 最好情况: 若初始序列已经排好序, 则需要进行n-1次比较, 而不需要发生交换;
 * 最坏情况: 需要执行n-1冒泡, 而且每次都需要进行n-i-1次交换;
 * 时间复杂度: O(n*n)
 * 空间复杂度:O(1)
 */

public class BubbleSort {

    public static void bubbleSort(int nums[]){
        //外层控制轮数, 比较轮数=数组长度-1;
        for (int i = 0; i < nums.length-1;i++){
            //每次遍历标志位都要先置为false, 才能判断后面的元素是否发生了交换
            boolean flag = false;
            //内层控制次数
            for (int j = 0; j < nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    /*
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    */
                    /*
                    nums[j] = nums[j] + nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] = nums[j] - nums[j+1];
                    */
                    //
                    nums[j] = nums[j]^nums[j+1];
                    nums[j+1] = nums[j]^nums[j+1];
                    nums[j] = nums[j]^nums[j+1];
                    flag = true;
                }
            }
            if (!flag){
                System.out.println("total loop:" + (i+1) + "time, stop at index " + i);
                break;
            }
        }
        for (int n: nums) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 5, 1, 0, 8, 6};
        bubbleSort(nums);
    }
}
