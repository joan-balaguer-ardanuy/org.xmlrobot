package org.xmlrobot;

import java.util.EventListener;

/**
 *
 */
public interface Listener 
	extends Message, 
		EventListener, 
			Runnable, 
				java.util.concurrent.ThreadFactory, 
					java.util.concurrent.Executor {
	
	/**
	 * Adds new {@link Listener} for current instance.
	 * @param listener {@link Listener} the new listener.
	 */
	void addEventListener(Listener listener);
	
	/**
	 * Removes new {@link Listener} for current instance.
	 * @param listener {@link Listener} the new listener.
	 */
	void removeEventListener(Listener listener);
	
	/**
	 * The event.
	 * @param e {@link EventArgs} the event arguments
	 */
	void event(Object sender, EventArgs e);
	
	Listener clone();
}