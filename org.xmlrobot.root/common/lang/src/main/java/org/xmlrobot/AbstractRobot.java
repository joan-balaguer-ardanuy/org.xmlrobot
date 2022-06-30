package org.xmlrobot;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import hyperspace.Entry;
import hyperspace.Hyperspace;

public class AbstractRobot<K,V>
	extends Hyperspace<Entry<K,V>,Entry<V,K>> 
		implements Robot<K,V> {

	private static final long serialVersionUID = 7659597817399739289L;

	@Override
	public K getInputKey() {
		return getKey().getKey();
	}
	@Override
	public K setInputKey(K key) {
		return getKey().setKey(key);
	}
	@Override
	public V getOutputValue() {
		return getKey().getValue();
	}
	@Override
	public V setOutputValue(V value) {
		return getKey().setValue(value);
	}
	@Override
	public K obtainKey(V value) {
		return getKey().getKey(value);
	}
	
	public AbstractRobot() {
	}
	public AbstractRobot(Class<? extends Robot<K,V>> type, String name, Entry<K,V> key) {
		super(type, name, key);
	}
	public AbstractRobot(Class<? extends Robot<K,V>> type, Class<? extends Robot<V,K>> antitype, String name, Entry<K,V> key, Entry<V,K> value) {
		super(type, antitype, name, key, value);
	}
	public AbstractRobot(Robot<K,V> parent, Entry<K,V> key) {
		super(parent, key);
	}
	public AbstractRobot(Class<? extends Robot<V,K>> antitype, Robot<K,V> parent, Entry<K,V> key, Entry<V,K> value) {
		super(antitype, parent, key, value);
	}
	public AbstractRobot(Robot<K,V> root, String name, Entry<K, V> key) {
		super(root, name, key);
	}
	public AbstractRobot(Class<? extends Robot<V,K>> antitype, Robot<K,V> root, String name, Entry<K,V> key, Entry<V,K> value) {
		super(antitype, root, name, key, value);
	}
	 
	@Override
	public V pushValue(K key, V value) {
		return getKey().putValue(key, value);
	}
	@Override
	public K pushKey(V value, K key) {
		return getKey().putKey(value, key);
	}
	@Override
	public V obtainValue(K key) {
		return getKey().getValue(key);
	}
	@Override
	public boolean hasValue(K key) {
		return getKey().containsValue(key);
	}
	@Override
	public boolean hasKey(V value) {
		return getKey().containsKey(value);
	}
	@Override
	public void releaseKey(K key) {
		getKey().removeKey(key);
	}
	@Override
	public void releaseValue(V value) {
		getKey().removeValue(value);
	}
	@Override
	public void release() {
		getKey().clear();
	}
	
	transient Set<K> keySet;
	transient Collection<V> values;
	
	@Override
	public Set<K> keySet() {
		Set<K> ks = keySet;
		if (ks == null) {
			ks = new AbstractSet<K>() {
				public Iterator<K> iterator() {
					return new Iterator<K>() {
						private Iterator<Entry<K, V>> i = getKey().iterator();

						public boolean hasNext() {
							return i.hasNext();
						}

						public K next() {
							return i.next().getKey();
						}

						public void remove() {
							i.remove();
						}
					};
				}

				public int size() {
					return AbstractRobot.this.getKey().size();
				}

				public boolean isEmpty() {
					return AbstractRobot.this.getKey().isEmpty();
				}

				public void clear() {
					AbstractRobot.this.getKey().clear();
				}

				public boolean contains(Object k) {
					return AbstractRobot.this.getKey().containsKey(k);
				}
			};
			keySet = ks;
		}
		return ks;
	}
	@Override
	public Collection<V> values() {
		Collection<V> vals = values;
        if (vals == null) {
            vals = new AbstractCollection<V>() {
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        private Iterator<Entry<K,V>> i = getKey().iterator();

                        public boolean hasNext() {
                            return i.hasNext();
                        }

                        public V next() {
                            return i.next().getValue();
                        }

                        public void remove() {
                            i.remove();
                        }
                    };
                }

                public int size() {
                    return AbstractRobot.this.getKey().size();
                }

                public boolean isEmpty() {
                    return AbstractRobot.this.getKey().isEmpty();
                }

                public void clear() {
                	AbstractRobot.this.clear();
                }

                public boolean contains(Object v) {
                    return AbstractRobot.this.containsValue(v);
                }
            };
            values = vals;
        }
        return vals;
	}
	
	transient Set<Entry<K,V>> entrySet;
	
	@Override
	public Set<Entry<K,V>> entrySet() {
		
		return entrySet == null ? entrySet = new Set<Entry<K,V>>() {

			@Override
			public int size() {
				return AbstractRobot.this.getKey().size();
			}
			@Override
			public boolean isEmpty() {
				return AbstractRobot.this.getKey().isEmpty();
			}
			@Override
			public boolean contains(Object o) {
				if(AbstractRobot.this.getKey().getKey().getClass().isInstance(o)) {
					return AbstractRobot.this.getKey().containsKey(o);					
				}
				else if(AbstractRobot.this.getKey().getValue().getClass().isInstance(o)) {
					return AbstractRobot.this.getKey().containsValue(o);					
				}
				else {
					return false;
				}

			}
			
			transient Iterator<Entry<K,V>> iterator;
			
			@Override
			public Iterator<Entry<K,V>> iterator() {
				Iterator<Entry<K,V>> it = AbstractRobot.this.getKey().iterator();
				return iterator == null ? iterator = new Iterator<Entry<K,V>>() {

					@Override
					public boolean hasNext() {
						return it.hasNext();
					}

					@Override
					public Entry<K, V> next() {
						return it.next();
					}
					
				}: iterator;
			}
			@Override
			public Object[] toArray() {
				// Estimate size of array; be prepared to see more or fewer elements
		        Object[] r = new Object[size()];
		        Iterator<Entry<K, V>> it = iterator();
		        for (int i = 0; i < r.length; i++) {
		            if (! it.hasNext()) // fewer elements than expected
		                return Arrays.copyOf(r, i);
		            r[i] = it.next();
		        }
		        return it.hasNext() ? orderToArray(r, it) : r;
			}
			@Override
			@SuppressWarnings("unchecked")
		    public <T> T[] toArray(T[] a) {
		        // Estimate size of array; be prepared to see more or fewer elements
		        int size = size();
		        T[] r = a.length >= size ? a :
		                  (T[])java.lang.reflect.Array
		                  .newInstance(a.getClass().getComponentType(), size);
		        Iterator<Entry<K,V>> it = iterator();

		        for (int i = 0; i < r.length; i++) {
		            if (! it.hasNext()) { // fewer elements than expected
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
		            r[i] = (T)it.next();
		        }
		        // more elements than expected
		        return it.hasNext() ? orderToArray(r, it) : r;
		    }
			@Override
			public boolean add(Entry<K, V> e) {
				throw new UnsupportedOperationException();
			}
			@Override
			public boolean remove(Object o) {
				Iterator<Entry<K,V>> it = iterator();
		        if (o==null) {
		            while (it.hasNext()) {
		                if (it.next()==null) {
		                    it.remove();
		                    return true;
		                }
		            }
		        } else {
		            while (it.hasNext()) {
		                if (o.equals(it.next())) {
		                    it.remove();
		                    return true;
		                }
		            }
		        }
		        return false;
			}
			@Override
			public boolean containsAll(Collection<?> c) {
				for (Object e : c)
		            if (!contains(e))
		                return false;
		        return true;
			}
			@Override
			public boolean addAll(Collection<? extends Entry<K, V>> c) {
				throw new UnsupportedOperationException();
			}
			@Override
			public boolean retainAll(Collection<?> c) {
				throw new UnsupportedOperationException();
			}
			@Override
			public boolean removeAll(Collection<?> c) {
				Objects.requireNonNull(c);
		        boolean modified = false;

		        if (size() > c.size()) {
		            for (Iterator<?> i = c.iterator(); i.hasNext(); )
		                modified |= remove(i.next());
		        } else {
		            for (Iterator<?> i = iterator(); i.hasNext(); ) {
		                if (c.contains(i.next())) {
		                    i.remove();
		                    modified = true;
		                }
		            }
		        }
		        return modified;
			}
			@Override
			public void clear() {
				AbstractRobot.this.getKey().clear();
			}
			
		} : entrySet;
	}
	@Override
	public void forEveryValue(BiConsumer<? super K, ? super V> action) {
		getKey().forEachValue(action);
	}
	@Override
	public void forEveryKey(BiConsumer<? super V, ? super K> action) {
		getKey().forEachKey(action);
	}
	@Override
	public boolean releaseValue(K key, V value) {
		return getKey().removeValue(key, value);
	}
	@Override
	public boolean releaseKey(V value, K key) {
		return getKey().removeKey(value, key);
	}
	@Override
	public void surrogateAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
		getKey().replaceAllValues(function);
	}
	@Override
	public void surrogateAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
		getKey().replaceAllKeys(function);
	}
	@Override
	public V processValueIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return getKey().computeValueIfAbsent(key, mappingFunction);
	}
	@Override
	public K processKeyIfAbsent(V value, Function<? super V, ? extends K> mappingFunction) {
		return getKey().computeKeyIfAbsent(value, mappingFunction);
	}
	@Override
	public V processValueIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return getKey().computeValueIfPresent(key, remappingFunction);
	}
	@Override
	public K processKeyIfPresent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return getKey().computeKeyIfPresent(value, remappingFunction);
	}
	@Override
	public V processValue(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return getKey().computeValue(key, remappingFunction);
	}
	@Override
	public K processKey(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return getKey().computeKey(value, remappingFunction);
	}
	@Override
	public V unifyValue(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return getKey().mergeValue(key, value, remappingFunction);
	}
	@Override
	public K unifyKey(V value, K key, BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
		return getKey().mergeKey(value, key, remappingFunction);
	}
}