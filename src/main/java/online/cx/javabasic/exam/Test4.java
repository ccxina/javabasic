package online.cx.javabasic.exam;

/**
 * Created on 2020/11/18.
 *
 * @author 曹鑫
 */
public class Test4 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean isfushu = false;
        if (x < 0) {
            isfushu = true;
        }
        String s = Math.abs(x) + "";
        StringBuilder s1 = new StringBuilder(s);
        s1 = s1.reverse(); // 
        if (s1.charAt(0) == 0) {
            s1 = s1.replace(0, 1, "");
        }
        String res = isfushu ? "-" + s1 : String.valueOf(s1);
        int reverseNum = 0;
        try {
            reverseNum = Integer.parseInt(String.valueOf(res));
        } catch (NumberFormatException e) {
        }
        return reverseNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1000));
    }

}
