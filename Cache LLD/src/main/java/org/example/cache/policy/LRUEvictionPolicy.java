package org.example.cache.policy;

import org.example.cache.ds.DoublyLinkedList;
import org.example.cache.ds.DoublyLinkedListNode;

import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    DoublyLinkedList<K> doublyLinkedList;
    Map<K, DoublyLinkedListNode<K>> keyNodeMap;

    @Override
    public void accessed(K key) {
        if (keyNodeMap.containsKey(key)) {
            DoublyLinkedListNode<K> node = keyNodeMap.get(key);
            doublyLinkedList.detachNode(node);
            doublyLinkedList.prependNode(key);
        } else {
            DoublyLinkedListNode<K> node = doublyLinkedList.prependNode(key);
            keyNodeMap.put(key, node);
        }
    }

    @Override
    public K evict() throws IllegalAccessException {
        DoublyLinkedListNode<K> node = doublyLinkedList.removeFromStart();
        K key = node.getKey();
        keyNodeMap.remove(key);
        return key;
    }
}
