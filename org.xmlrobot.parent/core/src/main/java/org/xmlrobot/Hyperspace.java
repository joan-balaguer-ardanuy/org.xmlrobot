/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlTransient;

public abstract class Hyperspace
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Child<K,V>
			implements TimeListener<K,V> {

	/**
	 * 4428935997216883052L
	 */
	private static final long serialVersionUID = 4428935997216883052L;

	@Override
	@XmlTransient
	public Order getCommand() {
		return super.getCommand();
	}
	@Override
	public void setCommand(Order command) {
		super.setCommand(command);
		sendEvent(new EventArgs(this));
	}
	
	/**
	 * {@link Hyperspace} class constructor.
	 */
	public Hyperspace() {
		super();
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param parity {@link Parity} the parity
	 */
	public Hyperspace(Parity parity) {
		super(parity);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param parity {@link Parity} the parity
	 * @param child the child
	 */
	public Hyperspace(Parity parity, V child) {
		super(parity, child);
		child.setChild(getParent());
		child.setParent(child);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param parent the parent
	 */
	public Hyperspace(K parent) {
		super(parent);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Hyperspace(K parent, V child) {
		super(parent, child);
		child.getChild().setParent(parent.getChild().getChild());
		child.getChild().getChild().setParent(child);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public K clone() {
		try {
			K k = (K) super.clone();
			V v = (V) getChild().getClass().getConstructor().newInstance();
			k.setParent(k);
			v.setParent(v);
			k.setChild(v);
			v.setChild(k);
			return k;
		} catch (Throwable t) {
			throw new Error("org.xmlrobot.Hyperspace: clone exception.", t);
		}
	}

	@Override
	public void release() {
		call().setParent(getParent());
		get().setParent(getParent().getChild());
		put(getParent().put(call()));
		setParent(call());
		getChild().setParent(getChild());
	}
	@Override
	public abstract Transmitter<K,V> comparator();
	
	/**
	 * Information generator class. Implements {@code TimeListener.Transmitter}.
	 * @author joan
	 */
	public abstract class Generator implements TimeListener.Transmitter<K,V> {
		
		V source;
		
		@Override
		public V getSource() {
			return source;
		}
		@Override
		public void setSource(V source) {
			this.source = source;
		}
		public Generator() {
			this.source = null;
		}
		public Generator(V source) {
			this.source = source;
		}
		@Override
		public void compare(K parent, V child) {
			parent.compareTo(child);
			setSource(parent.comparator().getSource());
			K p = parent.getParent();
			V c = child.call();		
			while (p != parent && c != child) {
				c.compareTo(p);
				setParent(c.comparator().getSource());
				p = p.getParent();
				c = c.call();
				if (p != parent && c != child) {
					p.compareTo(c);
					setChild(p.comparator().getSource());
					p = p.getParent();
					c = c.call();
				}
			}
		}
		
		@Override
		public abstract void setChild(V child);
		
		@Override
		public abstract void setParent(K parent);
	}
}