package Sort;

import java.util.Arrays;

/**
 * 【参考资料】
 * [1].http://www.cnblogs.com/chengxiao/p/6129630.html#3856284
 * [2].https://www.cnblogs.com/jingmoxukong/p/4303826.html
 * [3].https://blog.csdn.net/u010452388/article/details/81283998
 * http://blog.jobbole.com/113552/
 * http://luxiangqiang.xn--6qq986b3xl/2019/01/07/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95%E4%B9%8B%E7%BE%8E%E3%80%90%E5%A0%86%E3%80%91/
 * 堆排序是利用堆这种数据结构而设计的一种排序算法, 堆排序是一种选择排序, 它的最坏、最好、平均时间复杂度均为O(nlogn), 空间复杂度O(1), 它也是不稳定排序。
 * 堆是具有以下性质的完全二叉树:
 *    每个结点的值都大于或等于其左右孩子结点的值, 称为大顶堆;
 *    每个结点的值都小于或等于其左右孩子结点的值, 称为小顶堆。
 * 堆排序的基本思想是: 将待排序序列构造成一个大顶堆, 此时, 整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换, 此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆, 这样会得到n个元素的次小值。如此反复执行, 便能得到一个有序序列了。
 * 对于节点i:
 * 父节点 (i-1)/2
 * 左孩子节点 2 * i + 1
 * 右孩子节点 2 * i + 2
 */
public class HeapSort {

    /**
     *
     * @param nums
     */
    public static void heapSort(int[] nums){
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        int length = nums.length;

        int lastIndex = length / 2 - 1;//最后一个非叶子节点

        //把一个无序数组构建成一个大顶堆, 从最后一个非叶子节点开始
        for (int i = lastIndex; i >= 0; i--) {
            heapifyNR(nums, i, length);
        }

        //调整大顶堆
        for (int j = length - 1; j > 0; j--){
            swap(nums, 0, j);
            length--;
            heapifyNR(nums, 0, length);
        }
    }


    private static void heapify(int[] nums, int i, int length){
        if(i >= length) return;
        int left = (i << 1) + 1; //节点i的左孩子 等价于 2 * i + 1
        int right =  (i << 1) + 2; //节点i的右孩子 等价于 2 * i + 2
        int maxIndex = i; //假定当前节点i最大
        if (left < length && nums[maxIndex] < nums[left])
            maxIndex = left;
        if (right < length && nums[maxIndex] < nums[right])
            maxIndex = right;
        if (maxIndex != i){
            swap(nums, i, maxIndex);
            //递归处理
            heapify(nums, maxIndex, length);
        }
    }

    private static void heapifyNR(int[] nums, int i, int length){
        int child = (i << 1) + 1;
        while (child < length){
            //如果节点i有右孩子节点, 并且节点i右孩子的节点值 > 节点i左孩子的节点值, 则取右孩子节点
            if (child + 1 < length && nums[child+1] > nums[child]){
                child++;
            }
            //如果父结点的值已经大于孩子结点的值, 则直接结束
            if (nums[i] > nums[child]){
                break;
            }
            swap(nums, i, child);
            i = child;
            child = (child << 1) + 1;
        }
    }

    /**
     * 交换元素
     * @param nums
     * @param a
     * @param b
     */
    private static void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String args[]){
        int arr[] = {15, 17, 19, 13, 22, 16, 28, 30, 41, 62};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
