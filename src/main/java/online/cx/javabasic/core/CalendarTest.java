package online.cx.javabasic.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Cao Xin
 * @since 2021/3/17
 */
public class CalendarTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        int today = localDate.getDayOfMonth();
        localDate = localDate.minusDays(today - 1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int value = dayOfWeek.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.println("    ");
        }
        while (localDate.getMonthValue() == month) {
            System.out.printf("%3d", localDate.getDayOfMonth());
            if (today == localDate.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            localDate = localDate.plusDays(1);
            if (localDate.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }

}
