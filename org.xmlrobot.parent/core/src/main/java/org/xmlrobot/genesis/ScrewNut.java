/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import org.xmlrobot.Entry;
import org.xmlrobot.Parity;
import org.xmlrobot.ScrewDriver;
import org.xmlrobot.numbers.Enumerator;

/**
 * @author joan
 *
 */
public abstract class ScrewNut<K,V> 
	extends ScrewDriver<K,V> 
		implements Chain<K,V> {

	/**
	 * 2606906200987294519L
	 */
	private static final long serialVersionUID = 2606906200987294519L;

	public static final int MAX_ARRAY_SIZE = 2147483647;
	
	/**
	 * {@link ScrewNut} default class constructor.
	 */
	public ScrewNut() {
		super();
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param parity {@link Parity} the parity
	 */
	public ScrewNut(Parity parity) {
		super(parity);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param childClass {@link Class} the child class
	 * @param parity {@link Parity} the parity
	 * @param key the key
	 * @param value the value
	 */
	public ScrewNut(Class<? extends Screw<V,K>> childClass, Parity parity, K key, V value) {
		super(childClass, parity, key, value);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param parent the parent
	 */
	public ScrewNut(ScrewNut<K,V> parent) {
		super(parent);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param childClass {@link Class} the child class
	 * @param parent the parent
	 * @param key the key
	 * @param value the value
	 */
	public ScrewNut(Class<? extends Screw<V,K>> childClass, ScrewNut<K,V> parent, K key, V value) {
		super(childClass, parent, key, value);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param root the root
	 * @param parity {@link Parity} the parity
	 */
	public ScrewNut(ScrewNut<K,V> root, Parity parity) {
		super(root, parity);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param childClass  {@link Class} the child class
	 * @param root the root
	 * @param parity {@link Parity} the parity
	 * @param key the key
	 * @param value the value
	 */
	public ScrewNut(Class<? extends Screw<V,K>> childClass, ScrewNut<K,V> root, Parity parity, K key, V value) {
		super(childClass, root, parity, key, value);
	}

	@Override
	public DNA<V,K> entryDNA() {
		return (DNA<V,K>) getChild();
	}
	
	@Override
	public Iterator<Entry<K,V>> iterator() {
		Enumerator<Entry<K,V>> en = enumerator();
		return new Iterator<Entry<K,V>>() {
			@Override
			public boolean hasNext() {
				return en.hasMoreElements();
			}
			@Override
			public Entry<K,V> next() {
				return en.nextElement();
			}
			@Override
			public void remove() {
				en.remove();
			}
		};
	}
	
	public void clear() {
		release();
	}
	
	@Override
	public boolean contains(Object o) {
		Objects.requireNonNull(o);
		Enumerator<Entry<K,V>> en = enumerator();
		while (en.hasMoreElements())
            if (o.equals(en.nextElement()))
                return true;
        return false;
	}
	
	@Override
	public boolean add(Entry<K,V> e) {
		Objects.requireNonNull(e);
		submitChild(e, e.getChild());
		return true;
	}
	
	@Override
	public boolean remove(Object o) {
		Objects.requireNonNull(o);
		Enumerator<Entry<K,V>> en = enumerator();
		while (en.hasMoreElements()) {
			if (o.equals(en.nextElement())) {
				en.remove();
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c)
			if (!contains(o))
				return false;
		return true;
	}
	@Override
	public boolean addAll(Collection<? extends Entry<K, V>> c) {
		boolean modified = false;
		Enumerator<Entry<K,V>> en = enumerator();
		while(en.hasMoreElements())
			if (add(en.nextElement()))
				modified = true;
		return modified;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Enumerator<Entry<K,V>> en = enumerator();
		while (en.hasMoreElements()) {
			if (!c.contains(en.nextElement())) {
				en.remove();
				modified = true;
			}
		}
		return modified;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Enumerator<Entry<K,V>> it = enumerator();
		while (it.hasMoreElements()) {
			if (c.contains(it.nextElement())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}
	@Deprecated
	public int size() {
		int i = 0;
		Enumerator<?> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement();
			i++;
		}
		return i;
	}

	@Deprecated
	public Object[] toArray() {
		// Estimate size of array; be prepared to see more or fewer elements
        Object[] r = new Object[size()];
        Enumerator<Entry<K,V>> en = enumerator();
        for (int i = 0; i < r.length; i++) {
            if (!en.hasMoreElements()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = en.nextElement();
        }
        return en.hasMoreElements() ? finishToArray(r, en) : r;
	}

	@Deprecated
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		 // Estimate size of array; be prepared to see more or fewer elements
        int size = size();
        T[] r = a.length >= size ? a :
                  (T[])java.lang.reflect.Array
                  .newInstance(a.getClass().getComponentType(), size);
        Enumerator<Entry<K,V>> en = enumerator();

        for (int i = 0; i < r.length; i++) {
            if (! en.hasMoreElements()) { // fewer elements than expected
                if (a == r) {
                    r[i] = null; // null-terminate
                } else if (a.length < i) {
                    return Arrays.copyOf(r, i);
                } else {
                    System.arraycopy(r, 0, a, 0, i);
                    if (a.length > i) {
                        a[i] = null;
                    }
                }
                return a;
            }
            r[i] = (T)en.nextElement();
        }
        // more elements than expected
        return en.hasMoreElements() ? finishToArray(r, en) : r;
	}
	 /**
     * Reallocates the array being used within toArray when the iterator
     * returned more elements than expected, and finishes filling it from
     * the iterator.
     *
     * @param r the array, replete with previously stored elements
     * @param it the in-progress iterator over this collection
     * @return array containing the elements in the given array, plus any
     *         further elements returned by the iterator, trimmed to size
     */
	@Deprecated
    @SuppressWarnings("unchecked")
    private static <T> T[] finishToArray(T[] r, Enumerator<?> en) {
        int i = r.length;
        while (en.hasMoreElements()) {
            int cap = r.length;
            if (i == cap) {
                int newCap = cap + (cap >> 1) + 1;
                // overflow-conscious code
                if (newCap - MAX_ARRAY_SIZE > 0)
                    newCap = hugeCapacity(cap + 1);
                r = Arrays.copyOf(r, newCap);
            }
            r[i++] = (T)en.nextElement();
        }
        // trim if overallocated
        return (i == r.length) ? r : Arrays.copyOf(r, i);
    }
	@Deprecated
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError
                ("Required array size too large");
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
}