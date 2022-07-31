package org.xmlrobot;

public interface Map<K,V> extends java.util.Map.Entry<K, V>, java.util.Map<K, V>, Iterable<K> {

	K setKey(K key);
}
