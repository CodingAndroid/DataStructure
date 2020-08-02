package HackerEarth;

import java.util.Scanner;

/**
 * author: lihui1
 * date: 2019/11/13
 * email: 1316994947@qq.com
 * desc: Print Array in Reverse
 */

public class ArrayReverse {

    public static void reverse(){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = scanner.nextInt();
        }

        int i = 0;
        int j = array.length - 1;
        while (i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        for (int num: array) {
            System.out.println(num);
        }
    }

    /**
     * 二进制查询 Binary Queries
     * @return
     */
    private static void binaryQuery(){
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine().trim().split(" ")[1]);
        String[] stringArray = scanner.nextLine().trim().split(" ");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(stringArray[i]);
        }
        for (int j = 0; j < q; j++){
            String[] query = scanner.nextLine().trim().split(" ");
            if (query[0].equals("1")){
                int l = Integer.parseInt(query[1]) - 1;
                array[1] = 1 - array[1];
            } else {
                if (array[Integer.parseInt(query[2]) -1] == 0){
                    System.out.println("EVEN");
                } else {
                    System.out.println("ODD");
                }
            }
        }
    }

    private static void monk(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] stringArray = scanner.nextLine().trim().split(" ");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++){
            array[i] = Integer.parseInt(stringArray[i]);
        }
        String[] stringArray2 = scanner.nextLine().trim().split(" ");
        int[] array2 = new int[stringArray2.length];
        for (int j = 0; j < stringArray2.length; j++){
            array2[j] = Integer.parseInt(stringArray2[j]);
        }
        for (int m = 0; m < n; m++){
            System.out.print((array[m] + array2[m]) + " ");
        }
    }

    public static void main(String[] args) {

        monk();
    }
}
