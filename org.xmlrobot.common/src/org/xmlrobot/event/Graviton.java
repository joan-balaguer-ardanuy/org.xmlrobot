/**
 * 
 */
package org.xmlrobot.event;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.TimeListener;
import org.xmlrobot.time.Recursive;

/**
 * @author joan
 *
 */
public class Graviton<K,V>
	extends Tachyon<K,V> 
		implements Recursive<K,V> {

	/**
	 * 6469078510874914025L
	 */
	private static final long serialVersionUID = 6469078510874914025L;

	@Override
	public K getRoot() {
		return getSource().getRoot();
	}
	@Override
	public K setRoot(K root) {
		return getSource().setRoot(root);
	}
	@Override
	public V getStem() {
		return getSource().getStem();
	}
	@Override
	public V setStem(V stem) {
		return getSource().setStem(stem);
	}
	/**
	 * @param source
	 */
	public Graviton(Recursive<K,V> source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.event.Tachyon#getSource()
	 */
	@Override
	public Recursive<K,V> getSource() {
		return (Recursive<K,V>) super.getSource();
	}
	@Override
	public void spin() {
		getSource().spin();
	}
	@Override
	public void pushChild(K parent, V child) {
		getSource().pushChild(parent, child);
	}
	@Override
	public void popChild(K parent, V child) {
		getSource().popChild(parent, child);
	}
	@Override
	public void popParent(V child, K parent) {
		getSource().popParent(child, parent);
	}
	@Override
	public void permuteChild(K parent, V child) {
		getSource().permuteChild(parent, child);
	}
	@Override
	public void permuteParent(V child, K parent) {
		getSource().permuteParent(child, parent);
	}
	@Override
	public void pushParent(V child, K parent) {
		getSource().pushParent(child, parent);
	}
	@Override
	public void submitChild(K parent, V child) {
		getSource().submitChild(parent, child);
	}
	@Override
	public void submitParent(V child, K parent) {
		getSource().submitParent(child, parent);
	}
	@Override
	public int size() {
		return getSource().size();
	}
	@Override
	public V getChild(K key) {
		return null;
	}
	@Override
	public K getParent(V value) {
		return null;
	}
	@Override
	public V getChildOrDefault(K key, V defaultValue) {
		return null;
	}
	@Override
	public K getParentOrDefault(V value, K defaultKey) {
		return null;
	}
	@Override
	public V putChild(K key, V value) {
		return null;
	}
	@Override
	public K putParent(V value, K key) {
		return null;
	}
	@Override
	public V putChildIfAbsent(K key, V value) {
		return null;
	}
	@Override
	public K putParentIfAbsent(V value, K key) {
		return null;
	}
	@Override
	public V replaceChild(K key, V value) {
		return null;
	}
	@Override
	public K replaceParent(V value, K key) {
		return null;
	}
	@Override
	public boolean replaceChild(K key, V oldValue, V newValue) {
		return false;
	}
	@Override
	public boolean replaceParent(V value, K oldKey, K newKey) {
		return false;
	}
	@Override
	public void replaceAllChildren(BiFunction<? super K, ? super V, ? extends V> function) {
		
	}
	@Override
	public void replaceAllParents(BiFunction<? super V, ? super K, ? extends K> function) {
		
	}
	@Override
	public boolean removeChild(K key, V value) {
		return false;
	}
	@Override
	public boolean removeParent(V value, K key) {
		return false;
	}
	@Override
	public void forEachChild(BiConsumer<? super K, ? super V> action) {
		
	}
	@Override
	public void forEachParent(BiConsumer<? super V, ? super K> action) {

	}
	@Override
	public V computeChildIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return null;
	}
	@Override
	public K computeParentIfAbsent(V value, Function<? super V, ? extends K> mappingFunction) {
		return null;
	}
	@Override
	public V computeChildIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return null;
	}
	@Override
	public K computeParentIfPresent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return null;
	}
	@Override
	public V computeChild(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return null;
	}
	@Override
	public K computeParent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return null;
	}
	@Override
	public V mergeChild(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return null;
	}
	@Override
	public K mergeParent(V value, K key, BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
		return null;
	}
	@Override
	public K getPreviousParent() {
		return getSource().getPreviousParent();
	}
	@Override
	public int indexOfParent(K key) {
		return getSource().indexOfParent(key);
	}
	@Override
	public int lastIndexOfParent(K key) {
		return getSource().lastIndexOfParent(key);
	}
	@Override
	public void removeParent(int N) {
		getSource().removeParent(N);
	}
	@Override
	public V getNextChild() {
		return getSource().getNextChild();
	}
	@Override
	public int indexOfChild(V value) {
		return getSource().indexOfChild(value);
	}
	@Override
	public int lastIndexOfChild(V value) {
		return getSource().lastIndexOfChild(value);
	}
	@Override
	public void removeChild(int N) {
		getSource().removeChild(N);
	}
	@Override
	public void putAllChildren(TimeListener<? extends K, ? extends V> m) {
		getSource().putAllChildren(m);
	}
	@Override
	public void putAllParents(TimeListener<? extends V, ? extends K> m) {
		getSource().putAllParents(m);
	}
	@Override
	public K getParent(int N) {
		return getSource().getParent(N);
	}
	@Override
	public V getChild(int N) {
		return getSource().getChild(N);
	}
	@Override
	public boolean containsParent(K key) {
		return getSource().containsParent(key);
	}
	@Override
	public boolean containsChild(V value) {
		return getSource().containsChild(value);
	}
	@Override
	public boolean removeParent(K key) {
		return getSource().removeParent(key);
	}
	@Override
	public boolean removeChild(V value) {
		return getSource().removeChild(value);
	}
}