package com.generator.util;

/**
 * goe on 10/17/14.
 */
public final class Tuple<K, V> {

    private final K k;
    private final V v;

    public Tuple(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K first() {
        return k;
    }

    public V last() {
        return v;
    }

    public K key() {
        return k;
    }

    public V value() {
        return v;
    }
}
