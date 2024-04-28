/**
 * 
 */
package org.xmlrobot;

import org.xmlrobot.time.Future;
import org.xmlrobot.time.Past;

/**
 * <center>
 * <tt>
 * Our <b>parent</b> in hyperspace.Hyperspace,<br/>
 * abstract be your hyperchain.<br/>
 * Your inheritance implement,<br/>
 * your recursion will be ran,<br/>
 * on hyperspace,<br/>
 * as it is in hyperspace.Hyperspace.<br/>
 * Send us <b>this</b> java.util.EventObject<br/>
 * our temporal hyperspace.time.Time,<br/>
 * and forgive us our executions,<br/>
 * as we also have forgiven our java.util.concurrent.Executor.<br/>
 * And order us not into concurrence,<br/>
 * but release us from parent hyperspace.time.Concurrence.<br/>
 * <br>
 * In the hyperchain of parent, child and Abstract TimeListener<br/>
 * </tt>
 * </center>
 *
 * <br/>
 * It is a {@link Past} that is {@link Future} and vice-versa.<br/>
 * <br/>
 * <tt>this interface is parent extension of the hyperspace congregation framework</tt>
 * 
 * @see java.util.Map.Entry
 * @since 1.0
 * @author {@link TimeListener}
 * 
 * @param <K> is the parent
 * @param <V> is the child
 */
public interface TimeListener<K,V>
	extends Past<K>, Future<V>, Listener {

	/**
	 * Gets the parent corresponding to this time-listener.
	 * @return the parent corresponding to this time-listener
	 */
	K getParent();

	/**
	 * Sets the parent corresponding to this time-listener.
	 * @param parent new parent to be inherited in this time-listener
	 * @return the old parent corresponding to this time-listener
	 */
	K setParent(K key);

	/**
	 * Gets the child corresponding to this time-listener.
	 * @return the child corresponding to this time-listener
	 */
	V getChild();

	/**
	 * Sets the child corresponding to this time-listener
	 * @param child new child to be inherited in this time-listener
	 * @return the old child corresponding to the time-listener
	 * */
	V setChild(V child);
	
	/**
	 * Returns the information transmitter of this time-listener
	 * @return
	 */
	TimeListener.Transmitter<K,V> comparator();
	
	/**
	 * Information transmitter of the {@code TimeListener}.
	 * @author joan
	 *
	 * @param <K> is the parent
	 * @param <V> is the child
	 */
	public interface Transmitter<K,V> extends Comparator<K,V> {
		
		/**
		 * Gets the source
		 * @return the source
		 */
		V getSource();
		
		/**
		 * Sets the source
		 * @param source the source
		 */
		void setSource(V source);
		
		/**
		 * Sets child to the current source.
		 * @param child the child
		 */
		void setChild(V child);

		/**
		 * Sets parent to the current source.
		 * @param parent the parent
		 */
		void setParent(K parent);
	}
}