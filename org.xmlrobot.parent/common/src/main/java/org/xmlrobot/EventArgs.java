package org.xmlrobot;

import java.util.EventObject;

/**
 * Event arguments class.
 * Each fired event will have an argument that inherits this class.
 * 
 * @author joan
 *
 */
public class EventArgs extends EventObject implements Listener {

	/**
	 * 6347247597829991161L
	 */
	private static final long serialVersionUID = 6347247597829991161L;
	@Override
	public Order getCommand() {
		return getSource().getCommand();
	}
	@Override
	public void setCommand(Order command) {
		getSource().setCommand(command);
	}
	@Override
	public Parity getParity() {
		return getSource().getParity();
	}
	@Override
	public void setParity(Parity parity) {
		getSource().setParity(parity);
	}
	@Override
	public String getName() {
		return getSource().getName();
	}
	
	/**
	 * {@link EventArgs} default class constructor.
	 * @param key the key
	 * @param value the value
	 */
	public EventArgs(Listener listener) {
		super(listener);
	}
	
	@Override
	public Listener getSource() {
		return (Listener) super.getSource();
	}
	@Override
	public Listener clone() {
		return getSource().clone();
	}
	@Override
	public void run() {
		getSource().run();
	}
	@Override
	public void addEventListener(Listener listener) {
		getSource().addEventListener(listener);
	}
	@Override
	public void removeEventListener(Listener listener) {
		getSource().removeEventListener(listener);
	}
	@Override
	public void event(Object sender, EventArgs e) {
		getSource().event(sender, e);
	}
	@Override
	public Thread newThread(Runnable r) {
		return getSource().newThread(r);
	}
	@Override
	public void execute(Runnable command) {
		getSource().execute(command);
	}
}