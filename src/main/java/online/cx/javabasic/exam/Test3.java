package online.cx.javabasic.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2020/11/16.
 *
 * @author 曹鑫
 */
public class Test3 {

    static List<String> deleteCars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        Scanner end = new Scanner(sc.nextLine());
        while (end.hasNextInt()) {
            nums.add(end.nextInt());
        }
        List<String> colors = new ArrayList<>();
        end = new Scanner(sc.nextLine());
        while (end.hasNext()) {
            colors.add(String.valueOf(end.next()));
        }
        List<String> cards = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            cards.add(nums.get(i) + colors.get(i));
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < cards.size(); i++) {
            List<String> temp = cards;
            int size = cards.size() - returnNum(i, temp).size();
            max = Math.max(size, max);
            cards.addAll(deleteCars);
            deleteCars = new ArrayList<>();
        }
        System.out.println(max);
    }

    public static List<String> returnNum(int index, List<String> cards) {
        String card = cards.get(index);
        int cardNum = card.charAt(0);
        char cardColor = card.charAt(1);
        deleteCars.add(card);
        cards.remove(index);
        for(int i = 0; i < cards.size(); i++) {
            int num = cards.get(i).charAt(0);
            char color = cards.get(i).charAt(1);
            if (num == cardNum || color == cardColor) {
                returnNum(i, cards);
            }
        }
        return cards;
    }
}
