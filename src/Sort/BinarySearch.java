package Sort;

/**
 * author: lihui1
 * date: 2018/7/25
 * email: 1316994947@qq.com
 * desc: 二分查找
 * 1. 定义: 二分查找又称折半查找, 它是一种效率较高的查找方法. 二分查找要求: 线性表是有序表, 即表中结点按关键字有序, 并且要用向量作为表的存储结构. 不妨设有序表是递增有序的.
 * 2. 限制: 对于有序数组, 才能使用二分查找法; 二分查找只适用顺序存储结构。
 * 3. 思想: 设R[low, ... , high]是当前查找的区间, 首先确定该区间的中点位置 mid = low + (high - low)/2;
 *         然后将待查的K值与R[mid].key比较:若相等, 则查找成功并返回此位置, 否则确定新的查找区间, 继续二分查找，具体方法如下:
 *         (1)若R[mid].key>K, 则由表的有序性可知R[mid, ..., R.length-1].keys均大于K, 因此若表中存在关键字等于K的结点,
 *            则该结点必定是在位置mid左边的子表R[0, ..., mid-1]中, 故新的查找区间是左子表R[0, ..., mid-1].
 *         (2)若R[mid].key< K, 则要查找的K必在mid的右子表R[mid+1, ..., R.length-1]中,
 *            即新的查找区间是右子表R[mid+1, ..., R.length-1]。下一次查找是针对新的查找区间进行的.
 *         因此, 从初始的查找区间R[0, ..., R.length-1]开始, 每经过一次与当前查找区间的中点位置上的结点关键字的比较, 就可确定查找是否成功,
 *         不成功则当前的查找区间就缩小一半. 这一过程重复直至找到关键字为K的结点, 或者直至当前的查找区间为空(即查找失败)时为止。
 * 4. 时间复杂度: O(logn)
 * 5. 题目: 给定一个排序的整数数组(升序)和一个要查找的整数target,
 *         用O(logn)的时间查找到target第一次出现的下标(从0开始),
 *         如果target不存在于数组中, 返回-1.
 *         样例:
 *         在数组[1, 2, 3, 3, 4, 5, 10]中二分查找3, 返回2.
 *
 */

public class BinarySearch {

    /**
     * 二分查找: 非递归 while循环
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int nums[], int target){

        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0; //左边界
        int end = nums.length - 1; //右边界
        while (start <= end){
            int mid = start + (end - start)/2; //规范, 防止整型溢出
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                start = mid + 1; //右边查找, [mid+1, ..., end]
            } else if (nums[mid] > target){
                end = mid - 1; //左边查找, [start, ..., mid-1]
            }
        }
        return -(start+1);
    }

    /**
     * 二分查找: 非递归 for 循环
     * @param nums
     * @param target
     * @return
     */
    public static int binaryFind(int nums[], int target){
        int start = 0;
        int end = nums.length - 1;
        for (int i = start + (end - start)/2; i>=0;){
            //System.out.println("i="+i);
            if (nums[i] == target){
                return i;
            } else if (target < nums[i]){
                end = i - 1;
                i--;
            } else if (target > nums[i]){
                start = i +1;
                i++;
            }
            if (nums[start] == target){
                System.out.println("i="+i);
                return start;
            }
            if (nums[end] == target){
                System.out.println("i="+i);
                return end;
            }
        }
        return -1;
    }

    /**
     * 二分查找: 递归
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int recursionBinarySearch(int nums[], int start, int end, int target){

        if (nums == null || nums.length == 0 || start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //防止溢出

        if (nums[mid] == target){
            return mid;
        }

        if (nums[mid] < target){
            //递归右边
            return recursionBinarySearch(nums, mid+ 1, end, target);
        }

        if (nums[mid] > target){
            //递归左边
            return recursionBinarySearch(nums, 0, mid - 1, target);
        }

        return -(start+1);
    }

    /**
     * 暴力方法: 遍历
     * @param nums
     * @param target
     * @return
     */
    public static int baoli(int nums[], int target){
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int nums[] = {1,4,4,5,7,7,8,9,9,10};
        System.out.println("position="+binarySearch(nums, 1));
    }
}
