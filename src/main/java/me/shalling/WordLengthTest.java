package me.shalling;

import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>58.最后一个单词长度</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @see <a href="https://leetcode.cn/problems/length-of-last-word/">leetcode-58</a>
 * @since 2022/10/20 11:27
 */
public class WordLengthTest {
  public int lengthOfLastWord(String s) {
    // skip empty string
    if (null == s || s.length() == 0) {
      return 0;
    }
    int length = s.strip().length();
    byte[] bytes = s.strip().getBytes();
    if (length == 0) {
      return 0;
    }
    int count = 0;
    for (int end = length - 1; end >= 0; end--) {
      if (bytes[end] == ' ' || bytes[end] == '\t') {
        break;
      }
      count++;
    }
    return count;
  }

  /**
   * @description 测试案例
   */
  @Test
  public void lengthOfLastWordTest() {
    String s = "   fly me   to   the moon  ";
    System.out.println(lengthOfLastWord(s));
  }
}
