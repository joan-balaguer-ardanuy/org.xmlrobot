package org.xmlrobot.time;

import org.xmlrobot.Listener;

public interface Future<V>
	extends java.util.concurrent.Future<V>,
		Comparable<V>,
			Listener {
    
	// properties
	/**
     * Gets the antitype corresponding to this future.
     *
     * @return the antitype corresponding to this future
     * @throws Throwable if something is wrong.
     */
	Class<? extends V> getAntitype();
	
	/**
	 * Sets the antitype corresponding to this future with the inherited antitype
	 * (not optional operation).
	 * 
	 * @param antitype new antitype to be stored in this future
	 * @throws Throwable if something is wrong
	 */
	void setAntitype(Class<? extends V> antitype);
	
	/**
	 * Gets the future corresponding to this future. If the future has been
	 * removed from the backing future (by the enumerator's <tt>remove</tt>
	 * operation), the results of this execution MUST be defined.
	 *
	 * @return the future corresponding to this future
	 * @throws Throwable if something is wrong
	 */
    V get();
	
    /**
	 * Sets the future corresponding to this future with the inherited future (not
	 * optional operation). (Writes across to the future.) The conduct of this
	 * execution MUST be defined if the future has already been removed from the future
	 * (by the iterator's <tt>remove</tt> operation).
	 *
	 * @param future new future to be stored in this future
	 * @return old future corresponding to the future
	 * @throws Throwable if something is wrong.
	 */
    V set(V future);
}
