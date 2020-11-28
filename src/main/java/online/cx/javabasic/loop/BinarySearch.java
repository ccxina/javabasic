package online.cx.javabasic.loop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/21 17:21
 */
public class BinarySearch {

    /**
     * searches element k in a sorted array
     * @param arr a sorted array
     * @param k the element to search
     * @return
     */
    public int binarySearch(int[] arr, int k){
        int a = 0;
        int b = arr.length;
        while (a < b){
            int m = a + (b - a) / 2;

            if(k < arr[m]){
                b = m;
            }else if (k > arr[m]){
                a = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[]{1,23,78,700}, 78));
    }
}
