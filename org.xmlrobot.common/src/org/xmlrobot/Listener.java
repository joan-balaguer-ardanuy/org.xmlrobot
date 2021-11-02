package org.xmlrobot;

import org.xmlrobot.event.Tachyon;

/**
 * <center>
 * <tt>
 * Our <b>org.xmlrobot.Parent</b> in org.xmlrobot.Hyperspace,<br/>
 * abstract be your hyperchain.<br/>
 * Your inheritance implement,<br/>
 * your recursion will be ran,<br/>
 * on hyperspace,<br/>
 * as it is in org.xmlrobot.Hyperspace.<br/>
 * Send us <b>this</b> instant<br/>
 * our instantly org.xmlrobot.time.Time,<br/>
 * and forgive us our executions,<br/>
 * as we also have forgiven our java.util.concurrent.Executor.<br/>
 * And order us not into concurrence,<br/>
 * but release us from parent org.xmlrobot.time.Concurrence.<br/>
 * <br>
 * In the hyperchain of parent, child and Abstract TimeListener<br/>
 * </tt>
 * </center>
 * @author {@link TimeListener}
 *
 */
public interface Listener 
	extends Cloneable,
		Runnable,
			java.io.Serializable,
				java.util.EventListener,
					java.util.concurrent.Executor,
						java.util.concurrent.ThreadFactory {
	// properties
	/**
	 * Gets the name.
	 * @return the name
	 */
	java.lang.String getName();
	
	/**
	 * Gets the gender.
	 * @return the gender
	 */
	Parity getGen();
	
	/**
	 * Sets the gender.
	 * @param gen the gender
	 */
	void setGen(Parity gen);
	
	/**
	 * Gets the command.
	 * @return the command
	 */
	Command getCommand();
	
	/**
	 * Sets the command.
	 * @param command the command
	 */
	void setCommand(Command command);
	
	/**
	 * Gets the runner.
	 * @return the runner
	 */
	Thread getRunner();
	
	/**
	 * Sets the runner.
	 * @param the runner
	 */
	void setRunner(Thread runner);

	// events
	/**
	 * Sets the listener.
	 * @param listener the listener
	 */
	void setListener(Listener listener);
	
	/**
	 * Event received.
	 * @param sender the sender of this event
	 * @param event the received event
	 */
	void event(Listener sender, Tachyon<?,?> event);
}