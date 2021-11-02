package org.xmlrobot.time;

import org.xmlrobot.Parity;

public abstract class Order
	<K extends Recursive<K,V>,V extends Recursive<V,K>> 
		extends Inheritance<K,V>  
			implements Recursive<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2085368953456448432L;
	/**
	 * {@link Order} default class constructor.<br/>
	 * 1. instance this and child;<br/>
	 * 2. setParent(this) and setChild(child);<br/>
	 * 3. child.setChild(this);<br/>
	 * 4. setRoot(this) and setStem(value);<br/> 
	 */
	public Order() {
		super();
	}
	/**
	 * {@link Order} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Order(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Order(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
	}
	/**
	 * {@link Order} class constructor.
	 * @param parent the parent
	 */
	public Order(K parent) {
		super(parent);
	}
	/**
	 * {@link Order} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Order(K parent, V child) {
		super(parent, child);
	}
	/**
	 * {@link Order} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 */
	public Order(K root, Parity gen) {
		super(root, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Order(K root, Parity gen, V child) {
		super(root, gen, child);
	}
}
