package me.shalling;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/20 10:47
 */
public class RemoveArrayDefinitionValue {
  public int removeElement(int[] list, int matchValue) {
    if (list.length == 0) {
      return 0;
    }
    int count = list.length;
    for (int i = 0; i < list.length - 1; ++i) {
      if (list[i] == matchValue) {
        list[i] = list[i + 1];
      }
    }
    return count;
  }
}
