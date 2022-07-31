package org.xmlrobot;

import java.util.Set;

import java.util.Map.Entry;

public interface EntrySet<K,V> extends java.util.Map.Entry<K,V>, Set<hyperspace.Entry<K,V>> {

	K getKey();

	K setKey(K key);

	V getValue();

	V setValue(V value);
	
	V put(K key, V value);
}
