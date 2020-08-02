package Util;

/**
 * author: lihui1
 * date: 2019/10/4
 * email: 1316994947@qq.com
 * desc:
 */

public class Utils {

    public static void swap(int nums[], int i, int j){
        if (nums == null || i == j){
            return;
        }
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }

    public static void swap1(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swap2(int nums[], int i, int j){
        nums[i] = nums[i] + nums[j]; //5 = 4 + 1
        nums[j] = nums[i] - nums[j]; //4 = 5 - 1
        nums[i] = nums[i] - nums[j]; //1  = 5 - 4
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(Integer a, Integer b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
