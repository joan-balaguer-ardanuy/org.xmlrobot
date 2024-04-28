/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.xmlrobot.ScrewDriver;
import org.xmlrobot.numbers.Enumerator;
import org.xmlrobot.Parity;


/**
 * @author joan
 *
 */
public abstract class Screw<K,V> 
	extends ScrewDriver<K,V>
		implements DNA<K,V> {

	/**
	 * -1289997593164869118L
	 */
	private static final long serialVersionUID = -1289997593164869118L;

	/**
	 * {@link Screw} default class constructor.
	 */
	public Screw() {
		super();
	}
	/**
	 * {@link Screw} class constructor.
	 * @param parity {@link Parity} the parity
	 */
	public Screw(Parity parity) {
		super(parity);
	}
	/**
	 * {@link Screw} class constructor.
	 * @param childClass {@link Class} the child class
	 * @param parity {@link Parity} the parity
	 * @param key the key
	 * @param value the value
	 */
	public Screw(Class<? extends ScrewNut<V,K>> childClass, Parity parity, K key, V value) {
		super(childClass, parity, key, value);
	}
	/**
	 * {@link Screw} class constructor.
	 * @param parent {@link Screw} the parent
	 */
	public Screw(Screw<K,V> parent) {
		super(parent);
	}
	/**
	 * {@link Screw} class constructor.
	 * @param childClass {@link Class} the child class
	 * @param parent the parent
	 * @param key the key
	 * @param value the value
	 */
	public Screw(Class<? extends ScrewNut<V,K>> childClass, Screw<K,V> parent, K key, V value) {
		super(childClass, parent, key, value);
	}
	/**
	 * {@link Screw} class constructor.
	 * @param root {@link Screw} the root
	 * @param parity {@link Parity} the message
	 */
	public Screw(Screw<K,V> root, Parity parity) {
		super(root, parity);
	}
	/**
	 * {@link Screw} class constructor.
	 * @param childClass {@link Class} the child class
	 * @param root the root
	 * @param parity {@link Parity} the parity
	 * @param key the key
	 * @param value the value
	 */
	public Screw(Class<? extends ScrewNut<V,K>> childClass, Screw<K,V> root, Parity parity, K key, V value) {
		super(childClass, root, parity, key, value);
	}

	public V get(Object key) {
    	return getValue(key);
    }
	
    public V put(K key, V value) {
    	V old = get(key);
    	putValue(key, value);
    	return old;
    }
    
    public void putAll(Map<? extends K,? extends V> m) {
    	for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }
    
	@Override
	public V remove(Object key) {
		Iterator<org.xmlrobot.Entry<K, V>> en = iterator();
		org.xmlrobot.Entry<K, V> correctEntry = null;
		while (correctEntry == null && en.hasNext()) {
			org.xmlrobot.Entry<K, V> e = en.next();
			if (key.equals(e.getKey()))
				correctEntry = e;
		}
		V oldValue = null;
		if (correctEntry != null) {
			oldValue = correctEntry.getValue();
			correctEntry.release();
		}
		return oldValue;
	}

	@Deprecated
	public int size() {
		Iterator<org.xmlrobot.Entry<K,V>> it = iterator();
		int i = 0;
		while(it.hasNext()) {
			it.next();
			i++;
		}
		return i;
	}
	
	public void clear() {
		release();
	}
	
	transient Set<K> keySet;
	
    transient Collection<V> values;
    
    transient Set<java.util.Map.Entry<K,V>> entrySet;
    
	public Set<K> keySet() {
		return keySet == null ? keySet = new AbstractSet<K>() {
			@Override
			public Iterator<K> iterator() {
				Enumerator<K> en = new KeyEnumerator(getParent());
                return new Iterator<K>() {

					@Override
					public boolean hasNext() {
						return en.hasMoreElements();
					}
					@Override
					public K next() {
						return en.nextElement();
					}
                };
			}
			@Override
			public int size() {
				return Screw.this.size();
			}
			public boolean isEmpty() {
                return Screw.this.isEmpty();
            }
            public void clear() {
            	Screw.this.clear();
            }
            public boolean contains(Object k) {
                return Screw.this.containsKey(k);
            }
			
		} : keySet;
	}
	
	public Collection<V> values() {
		return values == null ? values = new AbstractCollection<V>() {
			public Iterator<V> iterator() {
				Enumerator<V> en = new ValueEnumerator(getParent());
				return new Iterator<V>() {

					@Override
					public boolean hasNext() {
						return en.hasMoreElements();
					}
					@Override
					public V next() {
						return en.nextElement();
					}
				};
            }
            public int size() {
                return Screw.this.size();
            }
            public boolean isEmpty() {
                return Screw.this.isEmpty();
            }
            public void clear() {
            	Screw.this.clear();
            }
            public boolean contains(Object v) {
                return Screw.this.containsValue(v);
            }
		}: values;
	}
	
	@Deprecated
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return entrySet == null ? entrySet = new AbstractSet<Map.Entry<K,V>>() {

			@Override
			public Iterator<java.util.Map.Entry<K, V>> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Map.Entry<K,V>>() {
					private Iterator<org.xmlrobot.Entry<K,V>> it = Screw.this.iterator();
					@Override
					public boolean hasNext() {
						return it.hasNext();
					}
					@Override
					public java.util.Map.Entry<K, V> next() {
						return it.next();
					}
					@Override
					public void remove() {
						it.remove();
					}
				};
			}

			@Override
			public int size() {
				return Screw.this.size();
			}
			public boolean isEmpty() {
                return Screw.this.isEmpty();
            }
            public void clear() {
            	Screw.this.clear();
            }
            public boolean contains(Object k) {
                return Screw.this.containsKey(k);
            }
			
		}: entrySet;
	}
	
	public class ValueEnumerator implements Enumerator<V> {

		/**
		 * The current time-listener.
		 */
		org.xmlrobot.Entry<K,V> current;

		/**
		 * The next time-listener.
		 */
		org.xmlrobot.Entry<K,V> next;

		/**
		 * If this recursor has next time-listener.
		 */
		boolean hasNext;

		public ValueEnumerator(org.xmlrobot.Entry<K,V> parent) {
			next = current = parent;
			hasNext = true;
		}

		@Override
		public boolean hasMoreElements() {
			return hasNext;
		}

		@Override
		public V nextElement() {
			org.xmlrobot.Entry<K,V> c = next;
			current = c;
			next = c.getParent();
			if (c == Screw.this)
				hasNext = false;
			else
				hasNext = true;
			return c.getValue();
		}

		@Override
		public void remove() {
			org.xmlrobot.Entry<K,V> k = next;
			current.release();
			if (!k.isEmpty()) {
				current = k;
				next = k.getParent();
			} else
				hasNext = false;
		}
	}
}