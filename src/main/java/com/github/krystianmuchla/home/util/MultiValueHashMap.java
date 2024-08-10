package com.github.krystianmuchla.home.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MultiValueHashMap<K, V> extends HashMap<K, List<V>> implements MultiValueMap<K, V> {
    @Override
    public void add(K key, V value) {
        this.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    @Override
    public void addAll(K key, List<V> values) {
        this.computeIfAbsent(key, k -> new ArrayList<>()).addAll(values);
    }

    @Override
    public Optional<V> getFirst(K key) {
        var value = get(key);
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(value.getFirst());
    }

    public static <T, S> MultiValueHashMap<T, S> of(T key, S value) {
        return new MultiValueHashMap<>() {{
            put(key, new ArrayList<>() {{
                add(value);
            }});
        }};
    }
}
