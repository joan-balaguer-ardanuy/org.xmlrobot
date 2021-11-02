package org.xmlrobot.time;


/**
 * The recurrence. A parent set.
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
public interface Recurrent<K> extends Past<K> {

	K getRoot();
	K setRoot(K root);

	// methods
	K getParent(int N);
	boolean containsParent(K key);
	boolean removeParent(K key);
	K getPreviousParent();
	int indexOfParent(K parent);
	int lastIndexOfParent(K parent);
	void removeParent(int N);
}