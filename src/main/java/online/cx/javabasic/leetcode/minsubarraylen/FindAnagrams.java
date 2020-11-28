package online.cx.javabasic.leetcode.minsubarraylen;

import java.util.*;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/29 9:14
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        if(s.length() <= p.length() || s == null || s.equals("")){
            return new ArrayList<>();
        }
        int l = 0, r = p.length() - 1;
        List<Integer> res = new ArrayList<>();

        int[] dict = new int[26];
        for(char c: p.toCharArray()){
            dict[c - 'a'] ++;
        }

        int[] curr = new int[26];
        for(int i = 0; i < p.length() ; i++){
            curr[s.charAt(i) - 'a'] ++;
        }

        if(isSame(curr,dict)){
            res.add(l);
        }

        while (r < s.length() - 1){
            curr[s.charAt(l) - 'a'] --;
            l++;
            r++;
            curr[s.charAt(r) - 'a'] ++;
            if(isSame(curr,dict)){
                res.add(l);
            }

        }

        return res;
    }


    public static void main(String[] args) {

        String s = "abab";
        String p = "ab";

        List<Integer> res = FindAnagrams.findAnagrams(s, p);
        for(int i: res){
            System.out.print(i + " ");
        }
    }

    public static boolean equalList(List list1, List list2){
        if(null != list1 && null != list2){
            if(list1.containsAll(list2) && list2.containsAll(list1)){
                return true;
            }
            return false;
        }
        return true;
    }


    public static boolean isSame(int[] a, int[] b){
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
