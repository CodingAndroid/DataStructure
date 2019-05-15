package DS_Array;

/**
 * author: lihui1
 * date: 2018/7/25
 * email: 1316994947@qq.com
 * desc: 合并排序数组 II
 * 合并两个排序的整数数组A和B变成一个新的数组
 * 样例
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 */

public class MergeArray {

    public static int[] mergeSortedArray(int a[], int b[]){
        int[] c= new int[a.length+ b.length];
        int index1 = 0;
        int index2 = 0;
        int curr =0 ;
        while(index1 < a.length && index2 < b.length ) {
            if(a[index1] < b[index2] ) {
                c[curr] = a[index1];
                index1++;
            } else {
                c[curr] = b[index2];
                index2++;
            }
            curr++;
        }

        while(index1 < a.length ){
            c[curr] = a[index1];
            curr++;
            index1++;
        }
        while(index2 < b.length ) {
            c[curr] = b[index2];
            curr++;
            index2++;
        }
        return c;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int b[] = {2, 4, 5, 6};
        System.out.print("[");
        for (int i = 0; i<8; i++){
            if (i == mergeSortedArray(a,b).length-1){
                System.out.print(mergeSortedArray(a, b)[i]);
            } else {
                System.out.print(mergeSortedArray(a, b)[i] + ",");
            }
        }
        System.out.print("]");
    }
}
