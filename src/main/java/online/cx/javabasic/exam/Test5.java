package online.cx.javabasic.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2020/11/28.
 *
 * @author 曹鑫
 */
public class Test5 {

    public static String deleteString(String s) {
        Map map = new HashMap<Integer, String>();
        int k = 0;
        for (int i = 0; i < s.length(); i++ ){
            for (int j = i + 2; j <= s.length(); j ++ ){
                String temp = s.substring(i, j);
                // 判断是否连续
                if (judgeString(temp)) {
                   map.put(i, temp);
                   k = i;
                }
            }
            if (map.size() == 1) {
                break;
            }
        }
        if (map.size() == 0) {
            return s;
        }
        String delete = (String) map.get(k);
        s = s.replace(delete, "");
        return deleteString(s);
    }

    public static boolean judgeString(String temp) {
        boolean flag = true;
        char[] chars = temp.toCharArray();
        for(int i = 1; i < chars.length; i++) {
            if (chars[i] - chars[i - 1] == 1) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        System.out.println(deleteString("bab"));
        // qwqe 不连续
        // abcd 连续
        // abd 左边连续
        // dab 右边连续
        // eabd 中间
        System.out.println(deleteString("ecdfgba"));
    }
}
