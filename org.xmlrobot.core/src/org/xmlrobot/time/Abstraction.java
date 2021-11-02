package org.xmlrobot.time;

import org.xmlrobot.Parity;

public abstract class Abstraction 
	<K extends Recursive<K,V>,V extends Recursive<V,K>> 
	extends Unification<K,V>  
		implements Recursive<K,V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190743859402952269L;
	/**
	 * {@link Abstraction} default class constructor.
	 */
	public Abstraction() {
		super();
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Abstraction(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Abstraction(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param input the key
	 */
	public Abstraction(K parent) {
		super(parent);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param parent the key
	 * @param child the child
	 */
	public Abstraction(K parent, V child) {
		super(parent, child);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 */
	public Abstraction(K root, Parity gen) {
		super(root, gen);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Abstraction(K root, Parity gen, V child) {
		super(root, gen, child);
	}
}
