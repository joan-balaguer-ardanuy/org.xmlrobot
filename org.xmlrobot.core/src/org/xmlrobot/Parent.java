/**
 * 
 */
package org.xmlrobot;

import org.xmlrobot.event.Tachyon;
import org.xmlrobot.util.Abort;

/**
 * @author joan
 *
 */
public abstract class Parent
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Genesis
		 implements TimeListener<K,V> {

	/**
	 * 4428935997216883052L
	 */
	private static final long serialVersionUID = 4428935997216883052L;

	/**
	 * The parent.
	 */
	private K parent;
	
	/**
	 * The child.
	 */
	private V child;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#getParent()
	 */
	public K getParent() {
		return parent;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#setParent(java.lang.Object)
	 */
	@Override
	public K setParent(K key) {
		K old = this.parent;
		this.parent = key;
		return old;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#getChild()
	 */
	public V getChild() {
		return child;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#setChild(java.lang.Object)
	 */
	@Override
	public V setChild(V value) {
		V old = this.child;
		this.child = value;
		return old;
	}
	
	/**
	 * {@link Parent} default class constructor.
	 */
	public Parent() {
		super();
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Parent(Class<? extends K> type, Parity gen) {
		super(gen);
		setType(type);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Parent(Class<? extends K> type, Parity gen, V child) {
		this(type, gen);
		setParent(type.cast(this));
		setChild(child);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parent the parent
	 */
	public Parent(K parent) {
		this(parent.getType(), parent.getGen());
		setParent(parent);
		setChild(parent.getChild());
	}
	/**
	 * {@link Parent} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Parent(K parent, V child) {
		this(parent.getType(), parent.getGen());
		setParent(parent);
		setChild(child);
	}
	
	@Override
	public void setCommand(Command command) {
		super.setCommand(command);
		sendMass(new Tachyon<>(this));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public K clone() {
		try {
			K k = getType().newInstance();
			V v = getAntitype().newInstance();
			k.setGen(getGen());
			v.setGen(getGen().get());
			k.setParent(k);
			v.setParent(v);
			k.setChild(v);
			v.setChild(k);
			return k;
		}
		catch (Throwable t) {
			throw new Abort(t);
		}
	}
	@Override
	public void run() {
//		compareTo(getChild());
		super.run();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#mass(org.xmlrobot.MassListener, org.xmlrobot.event.Tachyon)
	 */
	@Override
	public void event(Listener sender, Tachyon<?,?> event) {
		if(sender != this)
			sendMass(event);
	}
}
