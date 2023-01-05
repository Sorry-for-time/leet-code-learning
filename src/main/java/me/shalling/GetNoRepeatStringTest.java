package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>无重复子串的最长子串</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">leetcode-3</a>
 * @since 2022/10/20 15:40
 */
public class GetNoRepeatStringTest {
  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();

    ArrayList<Integer> integerArrayList = new ArrayList<>();
    int startCount = 0;

    for (int i = 1; i < chars.length; i++) {
      for (int j = 0; j < i; j++) {
        if (chars[i] != chars[j]) {
          startCount++;
        }
        if (chars[i] == chars[j]) {
          integerArrayList.add(startCount);
          // rest
          startCount = 0;
        }
      }
    }

    integerArrayList.sort((a, b) -> -Integer.compare(a, b));
    return integerArrayList.get(0);
  }

  @Test
  public void lengthOfLongestSubstringTest() {
    String str = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(str));
  }
}
