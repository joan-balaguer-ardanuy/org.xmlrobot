package org.xmlrobot;

import java.util.EventObject;

/**
 * Event arguments class.
 * Each fired event will have an argument that inherits this class.
 * 
 * @author joan
 *
 */
public class EventArgs<K,V> extends EventObject implements Listener, java.util.Map.Entry<K,V> {

	/**
	 * 6347247597829991161L
	 */
	private static final long serialVersionUID = 6347247597829991161L;

	V value;
	
	@SuppressWarnings("unchecked")
	@Override
	public K getKey() {
		return (K) super.getSource();
	}
	@Override
	public V getValue() {
		return value;
	}
	@Override
	public V setValue(V value) {
		V old = this.value;
		this.value = value;
		return old;
	}
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
	public EventArgs(K key, V value) {
		super(key);
		setValue(value);
	}
	/**
	 * {@link EventArgs} default class constructor.
	 * @param timeListener the time-listener
	 */
	public EventArgs(TimeListener<K,V> timeListener) {
		super(timeListener);
		setValue(timeListener.getChild());
	}
	
	@Override
	public Listener getSource() {
		return (Listener) super.getSource();
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
	public void event(Object sender, EventArgs<?,?> e) {
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