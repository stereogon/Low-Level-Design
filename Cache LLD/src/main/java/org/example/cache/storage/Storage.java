package org.example.cache.storage;

import org.example.cache.exception.CacheFullException;

public interface Storage<K, V> {
    void put(K key, V value) throws CacheFullException;
    V get(K key);
    void remove(K key);
}
