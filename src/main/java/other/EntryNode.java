package other;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EntryNode<K, T> {
  private K key;
  private T data;
  private EntryNode<K, T> next;
  private EntryNode<K, T> prev;
}
