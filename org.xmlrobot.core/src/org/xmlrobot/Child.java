/**
 * 
 */
package org.xmlrobot;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The toroid of unification.
 * 
 * @author joan
 *
 */
public abstract class Child
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Parent<K,V>
			implements TimeListener<K,V> {

	/**
	 * 6579841095273271785L
	 */
	private static final long serialVersionUID = 6579841095273271785L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Past#call()
	 */
	@Override
	public K call() {
		return getChild().getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Past#put(java.lang.Object)
	 */
	@Override
	public K put(K past) {
		return getChild().setChild(past);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Future#get()
	 */
	@Override
	public V get() {
		return getChild().getChild().getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Future#set(java.lang.Object)
	 */
	@Override
	public V set(V future) {
		return getChild().getChild().setChild(future);
	}
	/**
	 * {@link Child} default class constructor.
	 */
	public Child() {
		super();
	}
	/**
	 * {@link Child} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Child(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Child} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the value
	 */
	public Child(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
		child.setChild(getParent());
		child.setParent(child);
	}
	/**
	 * {@link Child} class constructor.
	 * @param parent the parent
	 */
	public Child(K parent) {
		super(parent);
	}
	/**
	 * {@link Child} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Child(K parent, V child) {
		super(parent, child);
		parent.put(getType().cast(this));
	}

	@Override
	public void run() {
		execute(getChild());
		super.run();
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#cancel(boolean)
	 */
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		try {
			if(mayInterruptIfRunning && Thread.currentThread().isAlive())
				setCommand(Command.TRANSFER);
			return true;
		}
		catch(Throwable t) {
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return getCommand() == Command.TRANSFER;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isDone()
	 */
	@Override
	public boolean isDone() {
		return getCommand() == Command.TRANSFER;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#get(long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return get();
	}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		return new ParentIterator(getParent());
	}


	/**
	 * @author joan
	 */
	protected final class ParentIterator implements Iterator<K> {
		
		/**
		 * The current time-listener.
		 */
		K current;
		
		/**
		 * The next time-listener.
		 */
		K next;
		
		/**
		 * If this recursor has next time-listener.
		 */
		boolean hasNext;
		
		public ParentIterator(K key) {
			next = current = key;
			hasNext = true;
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return hasNext;
		}

		public final K nextParent() {
			K k = next;
			current = k;
			next = k.getParent();
			if(k == Child.this)
				hasNext = false;
			else hasNext = true;
			return k;
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public K next() {
			return nextParent();
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			K k = next;
			current.clear();
			if(!k.isEmpty()) {
				current = k;
				next = k.getParent();
			}
			else hasNext = false;
		}
	}
}