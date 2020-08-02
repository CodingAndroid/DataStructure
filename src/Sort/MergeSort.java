package Sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/jingmoxukong/p/4308823.html
 * http://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort {

    public static void sort(int arr[]){
        int temp[] = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    /*递归排序*/
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right){
            int mid = (left + right) /2;
            /*System.out.println("mid="+mid);*/
            sort(arr, left, mid, temp);//左边归并排序, 使得左子序列有序;
            sort(arr, mid + 1, right, temp);//右边归并排序, 使得右子序列有序;
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    /*合并*/
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;      //临时数组指针
        while (i<=mid && j<=right){
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //若第一段序列还没扫描完，将其全部复制到合并序列
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        //若第二段序列还没扫描完，将其全部复制到合并序列
        while (j<=right){
            temp[t++] = arr[j++];
        }
        //将temp中的内容全部拷贝到原数组中去
        t=0;
        while (left<=right){
            arr[left++] = temp[t++];
        }
        System.out.println("子序列:"+Arrays.toString(arr));
    }

    public static void main(String args[]){
        int arr[] = {8,4,7,5,3,1,6,2};
        System.out.println("排序前:"+Arrays.toString(arr));
        //sortSub(arr);
        sort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }
}
