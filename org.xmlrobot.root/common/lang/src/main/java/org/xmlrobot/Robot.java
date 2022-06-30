package org.xmlrobot;

import java.util.Collection;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import hyperspace.Entry;

public interface Robot<K,V> extends Entry<Entry<K,V>,Entry<V,K>> {

	K getInputKey();
	K setInputKey(K key);
	
	V getOutputValue();
	V setOutputValue(V value);
	
	V obtainValue(K key);
	K obtainKey(V value);
	
	V pushValue(K key, V value);
	K pushKey(V value, K key);
	
	boolean hasValue(K key);
	boolean hasKey(V value);
	
	void releaseKey(K key);
	void releaseValue(V value);
	
	boolean releaseValue(K key, V value);
	boolean releaseKey(V value, K key);
	
	void release();
	
	Set<K> keySet();
	Collection<V> values();
	Set<Entry<K,V>> entrySet();
	
	void forEveryValue(BiConsumer<? super K, ? super V> action);
	void forEveryKey(BiConsumer<? super V, ? super K> action);
	
	void surrogateAllValues(BiFunction<? super K, ? super V, ? extends V> function);
	void surrogateAllKeys(BiFunction<? super V, ? super K, ? extends K> function);
	
	V processValueIfAbsent(K key, Function<? super K, ? extends V> mappingFunction);
    K processKeyIfAbsent(V value, Function<? super V, ? extends K> mappingFunction);
    
    V processValueIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
    K processKeyIfPresent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    V processValue(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
    K processKey(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    V unifyValue(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction);
    K unifyKey(V value, K key, BiFunction<? super K, ? super K, ? extends K> remappingFunction);
}