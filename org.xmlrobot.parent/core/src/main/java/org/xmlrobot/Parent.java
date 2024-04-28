package org.xmlrobot;

import java.util.Iterator;

import javax.xml.bind.annotation.XmlTransient;

/**
 * The parent {@link AbstractListener} class.
 * It is {@link TimeListener}.
 * @author joan
 *
 */
public abstract class Parent
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends AbstractListener
			implements TimeListener<K,V> {

	/**
	 * -2358327935955938422L
	 */
	private static final long serialVersionUID = -2358327935955938422L;

	/**
	 * The key.
	 */
	private K parent;
	
	/**
	 * The value.
	 */
	private V child;

	@Override
	@XmlTransient
	public K getParent() {
		return parent;
	}
	@Override
	public K setParent(K key) {
		K old = this.parent;
		this.parent = key;
		return old;
	}
	@Override
	@XmlTransient
	public V getChild() {
		return child;
	}
	@Override
	public V setChild(V value) {
		V old = this.child;
		this.child = value;
		return old;
	}

	public Parent() {
		super();
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parity {@link Parity} the parity
	 */
	public Parent(Parity parity) {
		super(parity);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parity {@link Parity} the parity
	 * @param child the child
	 */
	@SuppressWarnings("unchecked")
	public Parent(Parity parity, V child) {
		super(parity);
		setParent((K) this);
		setChild(child);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parent the parent
	 */
	public Parent(K parent) {
		super(parent.getParity());
		setParent(parent);
		setChild(parent.getChild());
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Parent(K parent, V child) {
		super(parent.getParity());
		setParent(parent);
		setChild(child);
	}
	
	@Override
	public abstract TimeListener<K,V> clone();
	
	@Override
	public boolean isEmpty() {
		return getParent() == this;
	}
	@Override
	public Iterator<K> iterator() {
		return new ParentIterator(getParent());
	}

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

		public ParentIterator(K parent) {
			next = current = parent;
			hasNext = true;
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public K next() {
			K parent = next;
			current = parent;
			next = parent.getParent();
			if (parent == Parent.this)
				hasNext = false;
			else
				hasNext = true;
			return parent;
		}

		@Override
		public void remove() {
			K parent = next;
			current.release();
			if (!parent.isEmpty()) {
				current = parent;
				next = parent.getParent();
			} else
				hasNext = false;
		}
	}
}