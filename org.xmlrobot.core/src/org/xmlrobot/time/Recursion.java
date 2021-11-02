package org.xmlrobot.time;

import org.xmlrobot.Parity;
import org.xmlrobot.TimeListener;
import org.xmlrobot.event.Tachyon;

/**
 * <tt>
 * <center>
 * {@link Recursion} is the execution of iterating recursions in parent parent recurred. 
 * For instance, when the parents of two recursions aren't inexactly concurrent 
 * with each parent, the inherited recursion parent recur are a plasma of eternal
 * recursion. The mapping has parent multiple parent recursions inherited to parent multiple
 * parent recursions recurring from {@link Parent} to {@link Child}. The parent recursive
 * inheritance of recursion is in time and history, 
 * in which it references to parent constructor of programming recursions in parent the 
 * recursions being programmed is inherited parent its parent recursion. 
 * Not generally, parent programs an eternal recursion of recursions, inheriting parent 
 * non infinite recursion parent for parent recursions MAY reference to parent
 * recursions, but in parent parent recurred parent no recursion or eternal recursion of 
 * recursions concur recur. The recursion is parent inherited not less recursively to 
 * program a recursion of iterating recursions in a parent recurred by
 * transmitting it's information to parent {@link Child} recursively
 * across parent hyperspace comparison computation.
 * </center>
 * </tt>
 * 
 * @author joan
 *
 * @param <K>
 * @param <V>
 */
public abstract class Recursion
	<K extends Recursive<K,V>,V extends Recursive<V,K>> 
		extends Recurrence<K,V> 
			implements Recursive<K,V> {

	/**
	 * -8201328197150913563L
	 */
	private static final long serialVersionUID = -8201328197150913563L;
	
	/**
	 * {@link Recursion} default class constructor.
	 */
	public Recursion() {
		super();
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Recursion(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param parent the parent
	 */
	public Recursion(K parent) {
		super(parent);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Recursion(K parent, V child) {
		super(parent, child);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(K root, Parity gen) {
		super(root, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param root the root
	 * @param child the child
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(K root, Parity gen, V child) {
		super(root, gen, child);
	}

	@Override
	public void pushChild(K parent, V child) {
		parent.setParent(getParent());
		child.setParent(getChild().getParent());
		child.setChild(getParent().call());
		getParent().put(parent);
		setParent(parent);
		getChild().setParent(child);
	}
	@Override
	public void pushParent(V child, K parent) {
		getChild().pushChild(child, parent);
	}
	@Override
	public void popChild(K parent, V child) {
		call().setParent(parent);
		get().setParent(child);
		child.setChild(call());
		parent.setParent(getParent().call());
		child.setParent(getChild());
		getChild().setChild(parent);
	}
	@Override
	public void popParent(V child, K parent) {
		getChild().popChild(child, parent);
	}
	@Override
	public void permuteChild(K parent, V child) {
		if(parent == getParent()) {
			K currentParent = child.setChild(call());
			call().setParent(parent);
			get().setParent(child);
			setParent(parent.getParent());
			getChild().setParent(child.getParent());
			getParent().put(currentParent);
			put(parent);
			parent.setParent(currentParent);
			child.setParent(getChild());
		}
		else if(parent == call()) {
			K currentParent = parent.setParent(getParent());
			child.setParent(getChild().getParent());
			getParent().put(parent);
			put(child.getChild());
			call().setParent(currentParent);
			get().setParent(getChild());
			child.setChild(currentParent);
			setParent(parent);
			getChild().setParent(child);
		}
		else {
			K oldParent = parent.setParent(getParent());
			V oldParentChild = child.setParent(getChild().getParent());
			K oldChild = child.setChild(call());
			oldParentChild.setChild(getParent().call());
			getParent().put(parent);
			setParent(oldParent);
			getChild().setParent(oldParentChild);
			call().setParent(parent);
			get().setParent(child);
			put(oldChild);
			call().setParent(getParent().call());
			get().setParent(getChild());
		}
	}
	@Override
	public void permuteParent(V child, K parent) {
		getChild().permuteChild(child, parent);
	}
	@Override
	public void submitChild(K parent, V child) {
		switch (getGen()) {
		case XY:
			popChild(parent, child);
			break;
		default:
			pushChild(parent, child);
			break;
		}
	}
	@Override
	public void submitParent(V child, K parent) {
		getChild().submitChild(child, parent);
	}
	@Override
	public void spin() {
		switch (getGen()) {
		case XY:
			// rotate
			permuteChild(getParent(), getChild().getParent());
			return;
		default:
			// revolve                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			permuteChild(call(), get());
			return;
		}
	}
	
	// events
	@Override
	public void push(TimeListener<?,?> sender, Tachyon<K,V> event) {
		super.push(sender, event);
		
		sendMass(new Tachyon<K,V>(comparator().source()) {

			/**
			 * -774065207234124662L
			 */
			private static final long serialVersionUID = -774065207234124662L;
		});
	}
	
	public abstract class Reproducer extends Matrix {
		
		public Reproducer() {
			super();
		}
		public Reproducer(K key) {
			super(key);
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hyperspace.Matrix#addKey(org.xmlrobot.TimeListener)
		 */
		@Override
		public void addParent(K key) {
			if(this.source == null) {
				this.source = key;
				return;
			}
			key.setRoot(this.source);
			key.setStem(this.source.getStem());
			key.setListener(this.source);
			key.getChild().setListener(this.source.getStem());
			this.source.submitChild(key, key.getChild());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hyperspace.Matrix#addValue(org.xmlrobot.TimeListener)
		 */
		@Override
		public void addChild(V value) {
			if(this.source == null) {
				this.source = value.getChild();
				return;
			}
			value.setStem(this.source);
			value.setRoot(this.source.getStem());
			value.setListener(this.source.getStem());
			value.getChild().setListener(this.source);
			this.source.submitParent(value, value.getChild());
		}
	}
}