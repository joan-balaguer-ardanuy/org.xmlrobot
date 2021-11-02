package org.xmlrobot.event;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.Entry;

/**
 * @author joan
 *
 * @param <K>
 * @param <V>
 */
public class Event<K,V> 
	extends Graviton<Entry<K,V>,Entry<V,K>>
		implements Entry<K,V> {

	/**
	 * -6401935847399177117L
	 */
	private static final long serialVersionUID = -6401935847399177117L;

	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getKey()
	 */
	@Override
	public K getKey() {
		return getSource().getKey();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getValue()
	 */
	@Override
	public V getValue() {
		return getSource().getValue();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		return getSource().setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Entry#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		return getSource().setKey(key);
	}
	
	/**
	 * @param source
	 */
	public Event(Entry<K,V> source) {
		super(source);
	}
	@Override
	public Entry<K,V> getSource() {
		return (Entry<K,V>) super.getSource();
	}
	@Override
	public Entry.Comparator<K,V> comparator() {
		return (Entry.Comparator<K,V>) super.comparator();
	}
	@Override
	public V getValue(K key) {
		return getSource().getValue(key);
	}
	@Override
	public K getKey(V value) {
		return getSource().getKey(value);
	}
	@Override
	public V getValueOrDefault(K key, V defaultValue) {
		return getSource().getValueOrDefault(key, defaultValue);
	}
	@Override
	public K getKeyOrDefault(V value, K defaultKey) {
		return getSource().getKeyOrDefault(value, defaultKey);
	}
	@Override
	public int indexOfKey(K key) {
		return getSource().indexOfKey(key);
	}
	@Override
	public int indexOfValue(V value) {
		return getSource().indexOfValue(value);
	}
	@Override
	public V putValue(K key, V value) {
		return getSource().putValue(key, value);
	}
	@Override
	public K putKey(V value, K key) {
		return getSource().putKey(value, key);
	}
	@Override
	public V putValueIfAbsent(K key, V value) {
		return getSource().putValueIfAbsent(key, value);
	}
	@Override
	public K putKeyIfAbsent(V value, K key) {
		return getSource().putKeyIfAbsent(value, key);
	}
	@Override
	public V replaceValue(K key, V value) {
		return getSource().replaceValue(key, value);
	}
	@Override
	public K replaceKey(V value, K key) {
		return getSource().replaceKey(value, key);
	}
	@Override
	public boolean replaceValue(K key, V oldValue, V newValue) {
		return getSource().replaceValue(key, oldValue, newValue);
	}
	@Override
	public boolean replaceKey(V value, K oldKey, K newKey) {
		return getSource().replaceKey(value, oldKey, newKey);
	}
	@Override
	public void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
		getSource().replaceAllValues(function);
	}
	@Override
	public void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
		getSource().replaceAllKeys(function);
	}
	@Override
	public boolean removeValue(K key, V value) {
		return getSource().removeValue(key, value);
	}
	@Override
	public boolean removeKey(V value, K key) {
		return getSource().removeKey(value, key);
	}
	@Override
	public void forEachKey(BiConsumer<? super K, ? super V> action) {
		getSource().forEachKey(action);
	}
	@Override
	public void forEachValue(BiConsumer<? super V, ? super K> action) {
		getSource().forEachValue(action);
	}
	@Override
	public V computeValueIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return getSource().computeValueIfAbsent(key, mappingFunction);
	}
	@Override
	public K computeKeyIfAbsent(V value, Function<? super V, ? extends K> mappingFunction) {
		return getSource().computeKeyIfAbsent(value, mappingFunction);
	}
	@Override
	public V computeValueIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return getSource().computeValueIfPresent(key, remappingFunction);
	}
	@Override
	public K computeKeyIfPresent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return getSource().computeKeyIfPresent(value, remappingFunction);
	}
	@Override
	public V computeValue(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return getSource().computeValue(key, remappingFunction);
	}
	@Override
	public K computeKey(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return getSource().computeKey(value, remappingFunction);
	}
	@Override
	public V mergeValue(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return getSource().mergeValue(key, value, remappingFunction);
	}
	@Override
	public K mergeKey(V value, K key, BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
		return getSource().mergeKey(value, key, remappingFunction);
	}
	@Override
	public Entry<K,V> getParentByKey(K key) {
		return getSource().getParentByKey(key);
	}
	@Override
	public Entry<V,K> getChildByValue(V value) {
		return getSource().getChildByValue(value);
	}
	@Override
	public org.xmlrobot.Entry.Comparator<K,V> comparator(K key, V value) {
		return getSource().comparator();
	}
	@Override
	public boolean containsKey(Object key) {
		return getSource().containsKey(key);
	}
	@Override
	public boolean containsValue(Object value) {
		return getSource().containsValue(value);
	}
	@Override
	public void removeKey(K key) {
		getSource().removeKey(key);
	}
	@Override
	public void removeValue(V value) {
		getSource().removeValue(value);
	}
	@Override
	public Comparator<K, V> comparator(Entry<K, V> source) {
		// TODO Auto-generated method stub
		return null;
	}
}