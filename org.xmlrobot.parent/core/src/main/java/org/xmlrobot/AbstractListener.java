package org.xmlrobot;

import java.util.Iterator;

import org.xmlrobot.numbers.Set;

public abstract class AbstractListener
	extends XML
		implements Listener {
	
	private static final long serialVersionUID = -6531537504810067678L;
	
	/**
	 * The listeners
	 */
	private Set<Listener> listeners;
	
	/**
	 * {@link AbstractListener} default class constructor
	 */
	public AbstractListener() {
		super();
	}
	/**
	 * {@link AbstractListener} class constructor.
	 * @param message {@link Parity} the parity
	 */
	public AbstractListener(Parity parity) {
		super(parity);
	}
	
	@Override
	public Listener clone() {
		try {
			return getClass().getConstructor().newInstance();
		} catch (Throwable t) {
			throw new Error("org.xmlrobot.AbstractListener: clone exception.", t);
		}
	}
	
	@Override
	public void addEventListener(Listener listener) {
		if(listeners == null) {
			listeners = new Listeners();
		}
		listeners.add(listener);
	}
	@Override
	public void removeEventListener(Listener listener) {
		if(listeners == null) {
			return;
		}
		listeners.remove(listener);
	}
	/**
	 * Sends event to all event {@link Listener} added in the set.
	 * @param e {@link EventArgs} the arguments of the event
	 */
	protected void sendEvent(EventArgs e) {
		if(listeners != null) {
			Iterator<Listener> iterator = listeners.iterator();
			while(iterator.hasNext()) {
				iterator.next().event(this, e);
			}
		}
	}
	@Override
	public void event(Object sender, EventArgs e) {
		sendEvent(e);
	}
	@Override
	public synchronized void run() {
		switch (getCommand()) {
		case LISTEN:
			setCommand(Order.TRANSFER);
			break;
		default:
			setCommand(Order.LISTEN);
			break;
		}
	}
	@Override
	public void execute(Runnable command) {
		try {
			newThread(command).start();
		}
		catch (Throwable t) {
			throw new Error(t);
		}
	}
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r);
	}
	/**
	 * Intances new object.
	 * @param <X> the parameter type of the returned object
	 * @param type the {@link Class} of the object.
	 * @param object the arguments of the construction of the object
	 * @return the new <X> instance
	 */
	protected static <X> X instance(Class<X> type, Object... objects) {
		try {
			return type.getDeclaredConstructor(getClasses(objects)).newInstance(objects);
		}
		catch(Throwable t) {
			throw new Error(t);
		}
	}
	
	private static Class<?>[] getClasses(Object... objects) {
		Class<?>[] classes = new Class<?>[objects.length];
		for(int i = 0; i < objects.length; i++) {
			classes[i] = objects[i].getClass();
		}
		return classes;
	}
}