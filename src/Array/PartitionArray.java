package Array;

/**
 * author: lihui1
 * date: 2018/7/25
 * email: 1316994947@qq.com
 * desc: 数组划分
 * 给出一个整数数组 nums 和一个整数 k. 划分数组(即移动数组nums中的元素)，使得:
 * 所有小于k的元素移到左边;
 * 所有大于等于k的元素移到右边;
 * 返回数组划分的位置, 即数组中第一个位置 i, 满足 nums[i] 大于等于 k.
 * 拓展: 快速排序
 */

public class PartitionArray {

    public static int partitionArray(int[] nums, int k) {
        if (nums.length == 0 || nums == null){
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int temp; //临时变量
        while (start <= end){
            while (start <= end && nums[start] < k){
                start++;
            }

            while (start <= end && nums[end] >= k){
                end--;
            }

            if (start <= end){
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }



    public static void main(String[] args) {
        int nums[] = {8, 6, 3, 2, 2, 1, 5};
        System.out.println("num[0]="+partitionArray(nums, 2));
    }
}
