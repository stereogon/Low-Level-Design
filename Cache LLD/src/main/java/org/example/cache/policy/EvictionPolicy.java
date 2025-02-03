package org.example.cache.policy;

public interface EvictionPolicy<K> {
    void accessed(K key);
    K evict() throws IllegalAccessException;
}
