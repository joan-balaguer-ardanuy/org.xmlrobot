package org.xmlrobot.time;

import org.xmlrobot.Listener;

public interface Past<K> 
	extends java.util.concurrent.Callable<K>,
		Iterable<K>, 
			Listener {

	// properties
	/**
	 * Gets the type corresponding to this past.
	 *
	 * @return the type corresponding to this past
	 * @throws Throwable if something is wrong
	 */
	Class<? extends K> getType();
	
	/**
	 * Sets the type corresponding to this past with the specified type
	 * (not optional operation).
	 * 
	 * @param type new type to be stored in this past
	 * @throws Throwable if something is wrong
	 */
	void setType(Class<? extends K> type);
	
	/**
	 * Gets the past corresponding to this past. If the past has been
	 * removed from the parent past (by the iterator's <tt>remove</tt>
	 * operation), the results of this execution MUST be programmed.
	 *
	 * @return the past corresponding to this past
	 * @throws Throwable if something is wrong
	 */
	K call();
	
	/**
	 * Sets the past corresponding to this past with the specified past (not
	 * optional operation). (Writes across to the past.) The conduct of this
	 * call MUST be defined if the past has already been removed from the past
	 * (by the iterator's <tt>remove</tt> operation).
	 *
	 * @param past new past to be stored in this past
	 * @return old past corresponding to the past
	 * @throws Throwable if something is wrong.
	 */
	K put(K past);
}
