package com.baidu.duershow.leetcode.mianshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0220 {
    /**
     * https://leetcode-cn.com/problems/is-unique-lcci/
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int index = 0; index < astr.length(); index++) {
            hashSet.add(astr.charAt(index));
        }
        return hashSet.size() == astr.length();
    }

    /**
     * https://leetcode-cn.com/problems/check-permutation-lcci/
     * 面试题 01.02. 判定是否互为字符重排
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        String a1 = new String(char1);
        String a2 = new String(char2);
        return a1.equals(a2);
    }

    public boolean CheckPermutation_2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] int1 = count(s1);
        int[] int2 = count(s2);
        for (int index = 0; index < int1.length; index ++) {
            if (int1[index] != int2[index]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String str) {
        int[] res = new int[26];
        char[] chars = str.toCharArray();
        for (char val : chars) {
            res[val-'a']++;
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/string-to-url-lcci/
     * 面试题 01.03. URL化
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        S = S.substring(0, length);
        S = S.replace(" ", "%20");
        return S;
    }
    public String replaceSpaces2(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char val = S.charAt(i);
            if (val == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(val);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
     * 面试题 01.04. 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        int[] res = new int[128];
        char[] chars = s.toCharArray();
        int flag = 0;
        for (char val : chars) {
            res[val] ++;
            if (res[val] % 2 == 1) {
                flag ++;
            } else {
                flag --;
            }
        }
        return flag <= 1;
    }
    public boolean canPermutePalindrome3(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char val : chars) {
            if (!set.add(val)) {
                set.remove(val);
            }
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindrome2(String s) {
        if (s.length() % 2 == 0) {
            HashMap<Character, Integer> res = reMap(s);
            for (Map.Entry<Character, Integer> entry : res.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    return false;
                }
            }
            return true;
        } else {
            int flag = 0;
            HashMap<Character, Integer> res = reMap(s);
            for (Map.Entry<Character, Integer> entry : res.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    flag ++;
                }
            }
            return flag == 1;
        }
    }

    private HashMap<Character, Integer> reMap(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char key : chars) {
            if (res.containsKey(key)) {
                int val = res.get(key);
                res.put(key, ++ val); // 先++很重要
            } else {
                res.put(key, 1);
            }
        }
        return res;
    }
}
