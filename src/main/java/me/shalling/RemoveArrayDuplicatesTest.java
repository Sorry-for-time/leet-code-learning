package me.shalling;

import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/20 10:09
 */
public class RemoveArrayDuplicates {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0 || null == nums) {
      return 0;
    }
    int prev = 0, next = 1;
    while (next < nums.length) {
      if (nums[prev + 1] != nums[next]) {
        nums[prev] = nums[next];
        prev++;
      }
      next++;
    }
    return prev;
  }

  @Test
  public void removeDuplicateTest() {

  }
}
