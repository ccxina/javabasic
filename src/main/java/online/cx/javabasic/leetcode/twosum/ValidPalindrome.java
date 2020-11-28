package online.cx.javabasic.leetcode.twosum;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/28 17:05
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome {


    public boolean isPalindrome(String s) {

        String newStr = s.replaceAll("[\\pP\\p{Punct}]","").replaceAll(" ","").toLowerCase();
        System.out.println(newStr);
        char[] c = newStr.toCharArray();
        int l = 0, r = c.length - 1;
        for(int i = 0; i < c.length; i++){
            if(c[l] != c[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "race a car";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(s));
    }
}
