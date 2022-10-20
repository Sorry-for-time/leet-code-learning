package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/20 10:09
 */
public class RemoveArrayDuplicatesTest {
  /**
   * @param nums int array
   * @return new length after remove duplicates
   * @description array remove duplicates
   */
  public int removeDuplicates(int[] nums) {
    // if the nums length is zero, just back the length
    if (nums.length == 0) {
      return 0;
    }
    int prev = 0, next = 1;
    for (; next < nums.length; next++) {
      // if the next value is not equal the prev value, increment prev and assign the next value to prev + 1 location
      if (nums[prev] != nums[next]) {
        nums[prev + 1] = nums[next];
        prev++;
      }
    }
    // the default prev is 0, so right back +1
    return ++prev;
  }

  @Test
  public void removeDuplicateTest() {
    int[] list = new int[]{
      12, 12, 23, 24, 24, 25
    };
    System.out.println(removeDuplicates(list));
    System.out.println(Arrays.toString(list));
  }
}
