package online.cx.javabasic.leetcode.minsubarraylen;


/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/29 15:39
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {

    public String minWindow(String s, String t) {

        if(s.equals("") || s == null ||s.length() < t.length()){
            return "";
        }

        int[] dict = new int[256];
        for(char c: t.toCharArray()){
            dict[c] ++;
        }

        int[] curr = new int[256];
        for(int i = 0; i < t.length(); i++){
            curr[s.charAt(i)]++;
        }

        int l = 0, r = t.length() - 1;
        String res = "";

        while (r < s.length() - 1 && l < s.length() -1){
            r++;
            curr[s.charAt(r)] ++;

            if(isCover(curr, dict)){
                String currRes = s.substring(l, r + 1);

                if(res != "" && currRes.length() > res.length()){
                    if(l == s.length() -1){
                        break;
                    }
                    curr[s.charAt(l)]--;
                    l++;
                    r--;
                }else {
                    res = currRes;

                }



            }

        }

        return res;
    }

    public static void main(String[] args) {
        String S = "ab", T = "b";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(S, T));
    }


    public boolean isCover(int[] a, int[] b){
        for (int i = 0; i < 256; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
