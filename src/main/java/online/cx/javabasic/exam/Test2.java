package online.cx.javabasic.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2020/11/16.
 *
 * @author 曹鑫
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        Scanner end = new Scanner(sc.nextLine());
        while (end.hasNextInt()) {
            nums.add(end.nextInt());
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i ++ ){
            for (int j = + 1; j < nums.size(); j++) {
                int temp = Math.abs(nums.get(i) + nums.get(j));
                min = Math.min(temp, min);
            }
        }
        System.out.println(min);
    }
}
