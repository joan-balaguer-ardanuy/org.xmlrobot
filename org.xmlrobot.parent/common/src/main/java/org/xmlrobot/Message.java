package org.xmlrobot;

import java.io.Serializable;

public interface Message extends Cloneable, Serializable {

	/**
	 * Returns the name of this instance.
	 * @return the name of this instance.
	 */
	String getName();
	
	/**
	 * Returns the command.
	 * @return the command.
	 */
	Order getCommand();
	
	/**
	 * Sets the command.
	 * @param command {@link String} the command
	 */
	void setCommand(Order command);
	
	/**
	 * Returns the {@link Parity}.
	 * @return {@link Parity}
	 */
	Parity getParity();
	
	/**
	 * Sets the {@link Parity}.
	 * @param parity {@link Parity}
	 */
	void setParity(Parity parity);
	
	Object clone();
}
