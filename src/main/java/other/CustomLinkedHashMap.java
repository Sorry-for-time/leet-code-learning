package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 自定义有序链表&hashmap 组合结构
 *
 * @param <K> 键类型
 * @param <V> 值类型
 */
public class CustomLinkedHashMap<K, V> implements Iterable<V> {
  /**
   * 用于保存 对应的 key 指向的链表的节点地址
   */
  private final HashMap<K, EntryNode<K, V>> map;

  /**
   * 双链表头部指针
   */
  private EntryNode<K, V> chainFront;

  /**
   * 双链表尾部指针
   */
  private EntryNode<K, V> chainRear;

  public CustomLinkedHashMap() {
    this.map = new HashMap<>();
  }

  @SafeVarargs
  public CustomLinkedHashMap(EntryNode<K, V>... entryNode) {
    this.map = new HashMap<>();
    for (EntryNode<K, V> kvEntryNode : entryNode) {
      this.set(kvEntryNode.getKey(), kvEntryNode.getData());
    }
  }

  /**
   * 更新或者添加新的键值队
   *
   * @param key      键
   * @param newValue 值
   */
  public void set(K key, V newValue) {
    var isContained = this.map.containsKey(key);
    // 已经存在节点的情况下
    if (isContained) {
      this.map.get(key).setData(newValue);
    }
    // 不存在节点的情况下
    else {
      // 空链表情况下
      if (this.chainFront == null) {
        this.chainRear = this.chainFront = new EntryNode<K, V>().setKey(key).setData(newValue);
        this.map.put(key, this.chainFront);
      }
      // 链表不为空的情况下
      else {
        var newNode = new EntryNode<K, V>().setKey(key).setData(newValue);
        this.map.put(key, newNode);
        this.chainRear.setNext(newNode);
        newNode.setPrev(this.chainRear);
        // 更新尾部节点
        this.chainRear = newNode;
      }
    }
  }

  /**
   * 根据键取得对应的值
   *
   * @param key 键
   * @return 匹配的值, 如果无为 null
   */
  public V get(K key) {
    var tmp = this.map.get(key);
    if (tmp != null) {
      return tmp.getData();
    }
    return null;
  }

  /**
   * 根据指定的键删除匹配的 key-value 键值对
   *
   * @param key 键
   * @return 被删除的值
   */
  public V remove(K key) {
    // map 里存在再删除
    if (this.map.containsKey(key)) {
      // 直接先从 map 里删除 key-value 键值对
      var willDeleteNode = this.map.remove(key);
      if (willDeleteNode == chainFront) {
        // 头节点的情况
        chainFront = willDeleteNode.getNext();
      } else if (willDeleteNode == chainRear) {
        chainRear = chainRear.getPrev();
      } else {
        willDeleteNode.getNext().setPrev(willDeleteNode.getPrev());
        willDeleteNode.getPrev().setNext(willDeleteNode.getNext());
      }
      return willDeleteNode.getData();
    } else {
      return null;
    }
  }

  /**
   * 清空自定义 map 所有数据
   */
  public void clear() {
    this.map.clear();
    this.chainFront = chainRear = null;
  }

  /**
   * key-value 映射定义
   *
   * @param key   键
   * @param value 值
   * @param <K>   键类型
   * @param <V>   值类型
   */
  public record Entry<K, V>(K key, V value) {
  }

  /**
   * 返回自定义 map 的有序 key-value 集合
   *
   * @return 映射结果集
   */
  public Set<Entry<K, V>> entrySet() {
    Set<Entry<K, V>> entrySet = new HashSet<>();
    var tmp = this.chainFront;
    while (tmp != null) {
      entrySet.add(new Entry<>(tmp.getKey(), tmp.getData()));
      tmp = tmp.getNext();
    }
    return entrySet;
  }

  @Override
  public Iterator<V> iterator() {
    return new Iterator<>() {
      private EntryNode<K, V> current = chainFront;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public V next() {
        var data = current.getData();
        current = current.getNext();
        return data;
      }
    };
  }

  @Override
  public void forEach(Consumer<? super V> action) {
    var current = this.chainFront;
    while (current != null) {
      action.accept(current.getData());
      current = current.getNext();
    }
  }
}
