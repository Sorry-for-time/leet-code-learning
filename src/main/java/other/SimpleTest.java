package other;

import java.util.stream.Stream;

/**
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2023/1/6 5:56
 */
public class SimpleTest {
  public static void main(String[] args) {
    CustomLinkedHashMap<String, String> integerLinkedMap = new CustomLinkedHashMap<>(new EntryNode<String, String>().setKey("Wayne").setData("bruce"));
    Stream
      .iterate(1, prev -> prev + 1).limit(10)
      .map(String::valueOf).forEach(e -> integerLinkedMap.set(e, e));

    integerLinkedMap.forEach(e -> System.out.print(e + '\t'));
    System.out.println();
    for (String str : new String[]{"1", "6", "10"}) {
      System.out.println(integerLinkedMap.remove(str));
    }
    integerLinkedMap.forEach(e -> System.out.print(e + '\t'));
    System.out.println();
    integerLinkedMap.set("4", "4444444444444444");
    integerLinkedMap.forEach(e -> System.out.print(e + '\t'));
    System.out.println();
    integerLinkedMap.clear();
    for (String str : new String[]{"some", "foo"}) {
      integerLinkedMap.set(str, str);
    }
    for (String s : integerLinkedMap) {
      System.out.print(s + "\t");
    }
    System.out.println();
    System.out.println(integerLinkedMap.get("foo"));

    for (CustomLinkedHashMap.Entry<String, String> stringStringEntry : integerLinkedMap.entrySet()) {
      System.out.println(stringStringEntry);
    }
  }
}
