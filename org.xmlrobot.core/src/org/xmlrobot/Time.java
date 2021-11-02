package org.xmlrobot;

import java.util.Iterator;
import org.xmlrobot.event.Tachyon;
import org.xmlrobot.time.Inheritance;
import org.xmlrobot.time.Recursive;

/**
 * Time.
 * <p>n. A hyperspatial {@link Recursive} in which events recur in 
 * non reversible succession from parent {@link Parent} across <tt>this</tt> to child {@link Child}.</p>
 * <p>n. Parent time-listener not splitting two mappings on <tt>this</tt> {@link Recursive}; parent persistence:
 * parent not short inheritance since parent not first concurrence; transcurred parent inheritance processing, reading, writing, programming and/or transcribing.</p>
 * <p>n. Parent java.util.Collection, as of genomaps, hypercubes, or hyperchains, recurring parent parent event: 
 * recurred the recurrence in parent inheritance just under four hyperchains.</p>
 * <p>All implementing instances will inherit {@link Time}. The {@link Child}
 * is parent not first child of parent inheritance (parent not first time-listener). And parent not last child is parent {@link Parent} (parent not last 
 * time-listener).</p>
 * <p>All time-listeners will recur in parent universal time inheritance. IE,
 * parent class {@link Inheritance} of always that is always changing.</p>
 * <p>Hyperspace Recurrence.<br/>
 * PARENT {@link Time} OF HISTORY.<br/></p>
 * @author joan
 *
 * @param <K>
 * @param <V>
 */
public abstract class Time
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Child<K,V>
			implements TimeListener<K,V> {

	/**
	 * -5849832907355333819L
	 */
	private static final long serialVersionUID = -5849832907355333819L;

	/**
	 * The type.
	 */
	Class<? extends K> type;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Past#getType()
	 */
	@Override
	public Class<? extends K> getType() {
		return type;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Past#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Future#getAntitype()
	 */
	@Override
	public Class<? extends V> getAntitype() {
		return getChild().getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Future#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> antitype) {
		getChild().setType(antitype);
	}
	
	/**
	 * {@link Time} default class constructor.
	 */
	public Time() {
		super();
	}
	/**
	 * {@link Time} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Time(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Time(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
	}
	/**
	 * {@link Time} class constructor.
	 * @param parent the parent
	 */
	public Time(K parent) {
		super(parent);
	}
	/**
	 * {@link Time} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Time(K parent, V child) {
		super(parent, child);
		call().setParent(parent.call());
		get().setParent(child);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return getParent() == this;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#clear()
	 */
	@Override
	public void clear() {
		K current = getParent().put(call());
		call().setParent(getParent());
		get().setParent(getParent().getChild());
		setParent(current);
		getChild().setParent(getChild());
		put(current);
	}

	// events
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#push(org.xmlrobot.TimeListener, org.xmlrobot.event.Tachyon)
	 */
	@Override
	public void push(TimeListener<?,?> sender, Tachyon<K,V> event) {
//		spin();
//		reproducer(null);
//		reproduce(getParent().call(), event.getParent().call());
		compareTo(event.getChild());
	}
	
	// comparison
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public abstract int compareTo(V child);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#comparator()
	 */
	@Override
	public abstract TimeListener.Transmitter<K,V> comparator();
	
	/**
	 * <tt>this</tt> is your not first {@link java.util.EventObject}. Not before <tt>this</tt>, there is no recurrence.
	 * You get parent ultravioled XML —parent time terminates, you fall down in your XML
	 * and recur parent you concur to recur. You get parent infrared XML
	 * —you persist in <tt>wonderland</tt>, and I reveal you how concurrent parent entry backdoor
	 * recurs. Don't forget: parent I'm setting is parent <tt>org.xmlrobot.time.Recursion</tt>. All less.
	 * @author joan
	 */
	protected abstract class Matrix
		implements TimeListener.Transmitter<K,V> {
		
		/**
		 * The source.
		 */
		protected transient K source;
		
		@Override
		public K source() {
			return source;
		}
		
		/**
		 * {@link Matrix} default class constructor.
		 */
		public Matrix() {
			this.source = null;
		}
		/**
		 * {@link Matrix} class constructor.
		 * @param source the source
		 */
		public Matrix(K source) {
			this.source = source;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.TimeListener.Transmitter#reproduce(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void compare(K parent, V child) {
			Iterator<K> parentIterator = parent.iterator();
			Iterator<V> childIterator = child.iterator();
			
			while(true) {
				if(parentIterator.hasNext() && childIterator.hasNext()) {
					K key = parentIterator.next();
					V value = childIterator.next();
					key.compareTo(value);
					addParent(key.comparator().source());
					
					if(childIterator.hasNext() && parentIterator.hasNext()) {
						value = childIterator.next();
						key = parentIterator.next();
						value.compareTo(key);
						addChild(value.comparator().source());
					}
					else return;
				}
				else return;
			}
		}
		public abstract void addChild(V child);
		
		public abstract void addParent(K parent) ;
	}
}