package org.xmlrobot;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import hyperspace.Entry;
import hyperspace.EventArgs;
import hyperspace.Hyperspace;
import hyperspace.Message;
import hyperspace.XML;

public class XML2
	<K extends Robot<K,V>,V extends Robot<V,K>>
		extends Hyperspace<K,V> 
			implements Robot<K,V> {

	private static final long serialVersionUID = 2893001885051512991L;
	
	Message xml;
	
	public Message getXML() {
		return xml;
	}
	
	public XML2() {
		super();
	}
	public XML2(XML message) {
		super(message);
	}
	public XML2(Class<? extends Robot<K,V>> parentClass, Class<? extends Robot<V,K>> childClass, XML message) {
		super(parentClass, childClass, message.getMessage());
	}
	public XML2(Robot<K,V> parent) {
		super(parent);
	}
	public XML2(Class<? extends Robot<V,K>> childClass, Robot<K,V> parent, K key, V value) {
		super(childClass, parent, key, value);
	}
	public XML2(Robot<K,V> root, XML message) {
		super(root, message);
	}
	public XML2(Class<? extends Robot<V,K>> childClass, Robot<K,V> root, XML message, K key, V value) {
		super(childClass, root, message, key, value);
	}
	
	@Override
	public void event(EventArgs e) {
		super.event(e);
		switch (e.getCommand()) {
		case EventType.STARTED:
			start();
			break;

		default:
			break;
		}
	}
	
	public void start() {
		for(V robot : this) {
			robot.start();
		}
	}
	public void stop() {
		for(V robot : this) {
			robot.stop();
		}
	}
	@Override
	public int size() {
		return 0;
	}
	@Override
	public boolean contains(Object o) {
		return containsValue(o);
	}
	@Override
	public Iterator<V> iterator() {
		return new ValueIterator(getParent());
	}
	@Override
	public <T> T[] toArray(T[] a) {
		return super.toArray(a);
	}
	@Override
	public boolean add(V e) {
		return instance(getParentClass(), getChildClass(), getParent(), getKey(), e) != null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		return removeValue((V)o);
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object e : c)
			if (!contains(e))
				return false;
		return true;
	}
	@Override
	public boolean addAll(Collection<? extends V> c) {
		boolean modified = false;
		for (V e : c)
			if (add(e))
				modified = true;
		return modified;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Iterator<?> it = iterator();
		while (it.hasNext()) {
			if (c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<V> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
	}

	protected final class ValueIterator implements Iterator<V> {
		
		/**
		 * The current time-listener.
		 */
		protected Entry<K,V> current;
		
		/**
		 * The next time-listener.
		 */
		protected Entry<K,V> next;
		
		/**
		 * If this recursor has next time-listener.
		 */
		protected boolean hasNext;
		
		public ValueIterator(Entry<K,V> key) {
			next = current = key;
			hasNext = true;
		}
		@Override
		public boolean hasNext() {
			return hasNext;
		}
		@Override
		public V next() {
			Entry<K,V> k = next;
			current = k;
			next = k.getParent();
			if(k == XML2.this)
				hasNext = false;
			else hasNext = true;
			return k.getValue();
		}
		@Override
		public void remove() {
			Entry<K,V> k = next;
			current.clear();
			if(!k.isEmpty()) {
				current = k;
				next = k.getParent();
			}
			else hasNext = false;
		}
	}
}