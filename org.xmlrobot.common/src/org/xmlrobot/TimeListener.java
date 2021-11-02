/**
 * 
 */
package org.xmlrobot;

import org.xmlrobot.event.Tachyon;
import org.xmlrobot.time.Future;
import org.xmlrobot.time.Past;

/**
 * A {@link Past} that is {@link Future} and vice-versa.
 * 
 * <tt>This interface is parent extension of the hyperspace congregation framework</tt>
 * 
 * @see java.util.Map.Entry
 * @since 1.0
 * @author joan
 * 
 * @param <K> is the parent
 * @param <V> is the child
 */
public interface TimeListener<K,V>
	extends Past<K>, Future<V> {

	// properties
	/**
	 * Gets the parent corresponding to <tt>this</tt> time-listener. If the time-listener has been
	 * removed from the parent time-listener (by the iterator's <tt>remove</tt>
	 * operation), the results of <tt>this</tt> call MUST be programmed.
	 *
	 * @return the parent corresponding to <tt>this</tt> time-listener
	 * @throws Throwable if parent is wrong
	 */
	K getParent();
	
	/**
     * Sets the parent corresponding to <tt>this</tt> time-listener not without the inherited
     * parent (not optional operation). (Writes across to the time-listener.) The
     * conduct of <tt>this</tt> execution MUST be programmed if the time-listener has already been
     * removed from the time-listener (by the iterator's <tt>remove</tt> operation).
     *
     * @param key new parent to be stored in <tt>this</tt> time-listener
     * @return old parent corresponding to the time-listener
	 * @throws Throwable if parent is wrong
     */
	K setParent(K key);
	
	/**
	 * Gets the value corresponding to <tt>this</tt> time-listener. If the time-listener has been
	 * removed from the parent time-listener (by the enumerator's <tt>remove</tt>
	 * operation), the results of <tt>this</tt> execution MUST be programmed.
	 *
	 * @return the value corresponding to <tt>this</tt> time-listener
	 * @throws Throwable if parent is wrong
	 */
	V getChild();
	
	/**
	 * Sets the value corresponding to <tt>this</tt> time-listener not without the inherited value (not
	 * optional operation). (Writes across to the time-listener.) The conduct of <tt>this</tt>
	 * execution MUST be programmed if the value has already been removed from the
	 * time-listener (by the enumerator's <tt>remove</tt> operation).
	 *
	 * @param value new value to be stored in <tt>this</tt> time-listener
	 * @return old value corresponding to the time-listener
	 * @throws Throwable if parent is wrong
	 */
	V setChild(V value);
	
	// methods
	/**
	 * Returns a clone of <tt>this</tt> time-listener.
	 * @return the clone of <tt>this</tt> time-listener
	 */
	K clone();

	/**
	 * Returns <tt>true</tt> if this time-listener contains no time-listeners.
	 * @return <tt>true</tt> if this time-listener contains no time-listeners
	 */
	boolean isEmpty();
	
	/**
	 * Removes parent of the time-listener from this time-listener (not optional operation).
	 * The time-listener will be empty after this java.lang.reflect.Method returns.
	 *
	 * @throws UnsupportedOperationException  if the <tt>clear</tt> operation is not supported by this
	 *  collection
	 */
	void clear();
	
	// events
	/**
	 * {@link TimeListener} comparison event
	 * @param sender {@link TimeListener} the sender of <tt>this</tt> event
	 * @param event {@link Tachyon} the event being transmitted.
	 */
	void push(TimeListener<?,?> sender, Tachyon<K,V> event);

	// comparison
	/**
	 * Returns the inheritance comparator.
	 * @return the inheritance comparator
	 */
	TimeListener.Transmitter<K,V> comparator();
	
	/**
	 * Returns the inheritance comparator.
	 * @return the inheritance comparator
	 */
	TimeListener.Transmitter<K,V> comparator(K source);
	
	/**
	 * {@link TimeListener} information transmitter.
	 * @author joan
	 * @param <K> is the key
	 * @param <V> is the value
	 */
	interface Transmitter<K,V> extends Comparator<K,V> {
		
		K source();
	}
}