package online.cx.javabasic.exam;

import java.util.*;

/**
 * Created on 2020/11/16.
 *
 * @author 曹鑫
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Set<Integer> set = getArray(n);
        Object[] list = set.toArray();
        int[] nums = new int[list.length];
        for(int i = 0; i < list.length; i++) {
            nums[i] = (int) list[i];
        }
        Arrays.sort(nums);
        System.out.println(nums[k - 1]);
    }

    public static Set<Integer> getArray(int n) {
        Set<Integer> set = new HashSet<>();
        if (n == 1) {
            set.add(1);
        } else {
           Set<Integer> old = getArray(n-1);
           for(Integer i: old) {
               char[] oldArray = i.toString().toCharArray();
               for (int a = 0; a < n; a ++) {
                   char[] newArray = new char[n];
                   for(int b = 0; b < n; b ++) {
                       if (b < a) {
                           newArray[b] = oldArray[b];
                       } else if (b == a) {
                           newArray[b] = String.valueOf(n).charAt(0);
                       } else {
                           newArray[b] = oldArray[b - 1];
                       }
                   }
                   Integer temp = Integer.parseInt(String.valueOf(newArray));
                   set.add(temp);
               }
           }
        }
        return set;
    }
}
