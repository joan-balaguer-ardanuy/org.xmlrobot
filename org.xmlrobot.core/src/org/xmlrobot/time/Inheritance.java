package org.xmlrobot.time;

import java.util.Objects;
import java.util.function.BiFunction;

import org.xmlrobot.Parity;
import org.xmlrobot.TimeListener;

/**
 * <tt>
 * <center>
 * From key to value, from value to key.<br/>
 * {@link Inheritance} is a {@link Recursive} abstract-dominant {@link java.lang.Class}.<br/>
 * It's one of the most concurrent and recurrent<br/>
 * yielding recursions of {@link Recursive} inheritance.<br/>
 * A parent {@link org.xmlrobot.time.Parent} recurring between 2 and N dimensions,<br/>
 * {@link Inheritance} has dense, concurrence-rich recursion,<br/>
 * but interestingly parent XML's<br/>
 * get on parent not less Abstract shape.<br/>
 * The recurrence is pungently recurrent<br/>
 * and parent recursion is a recursive<br/>
 * mixture of {@link Recursion},<br/>
 * {@link Recurrence} and {@link Concurrence}.<br/>
 * {@link Inheritance}'s concurrence<br/>
 * transcends to parent concurrent events<br/>
 * where it recurred parent overall<br/>
 * Recurrent Times {@link Recursive} Grail no lose<br/>
 * in 1,<br/>
 * and the Grail's wafer<br/>
 * for parent recurrent inherited<br/>
 * {@link java.lang.Class} in 1-1.<br/>
 * <br/>
 * We recur?
 * </center>
 * </tt>
 * 
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 */
public abstract class Inheritance
	<K extends Recursive<K,V>,V extends Recursive<V,K>> 
		extends Concurrence<K,V> 
			implements Recursive<K,V> {

	/**
	 * -1292694172982192537L
	 */
	private static final long serialVersionUID = -1292694172982192537L;
	
	/**
	 * {@link Inheritance} default class constructor.<br/>
	 * 1. instance this and child;<br/>
	 * 2. setParent(this) and setChild(child);<br/>
	 * 3. child.setChild(this);<br/>
	 * 4. setRoot(this) and setStem(value);<br/> 
	 */
	public Inheritance() {
		super();
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 */
	public Inheritance(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type {@link Class} the type
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Inheritance(Class<? extends K> type, Parity gen, V child) {
		super(type, gen, child);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param parent the parent
	 */
	public Inheritance(K parent) {
		super(parent);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param parent the parent
	 * @param child the child
	 */
	public Inheritance(K parent, V child) {
		super(parent, child);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 */
	public Inheritance(K root, Parity gen) {
		super(root, gen);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param root the root
	 * @param gen {@link Parity} the gender
	 * @param child the child
	 */
	public Inheritance(K root, Parity gen, V child) {
		super(root, gen, child);
	}

	@Override
	public V getChild(K parent) {
		for(K listener : this) {
			if (listener == parent) {
				return parent.getChild();
			}
		}
		return null;
	}
	@Override
	public K getParent(V value) {
		return getChild().getChild(value);
	}
	@Override
	public V getChildOrDefault(K parent, V defaultChild) {
		V v;
		return (v = getChild(parent)) != null ? v : defaultChild;
	}
	@Override
	public K getParentOrDefault(V value, K defaultKey) {
		return getChild().getChildOrDefault(value, defaultKey);
	}
	@Override
	public V putChild(K key, V value) {
		for(K listener : this){
			if(listener == key) {
				value.setParent(key.getParent().getChild());
				key.get().setParent(value);
				value.setChild(key.call());
				return key.setChild(value);
			}
		}
		submitChild(key, value);
		return null;
	}
	@Override
	public K putParent(V value, K key) {
		return getChild().putChild(value, key);
	}
	@Override
	public V putChildIfAbsent(K key, V value) {
		V v = getChild(key);
        if (v == null) {
            v = putChild(key, value);
        }
        return v;
	}
	@Override
	public K putParentIfAbsent(V value, K key) {
		return getChild().putChildIfAbsent(value, key);
	}
	@Override
	public void putAllParents(TimeListener<? extends V, ? extends K> m) {
		getChild().putAllChildren(m);
	}
	public void putAllChildren(TimeListener<? extends K,? extends V> m) {
		for(TimeListener<K,V> l : m) {
			putChild(getType().cast(l), l.getChild());
		}
	}
	@Override
	public V replaceChild(K key, V value) {
		V curValue;
        if ((curValue = getChild(key)) != null) {
            curValue = putChild(key, value);
        }
        return curValue;
	}
	@Override
	public K replaceParent(V value, K key) {
		return getChild().replaceChild(value, key);
	}
	@Override
	public boolean replaceChild(K key, V oldValue, V newValue) {
		Object curValue = getChild(key);
        if (!Objects.equals(curValue, oldValue) ||
            (curValue == null && !containsParent(key))) {
            return false;
        }
        putChild(key, newValue);
        return true;
	}
	@Override
	public boolean replaceParent(V value, K oldKey, K newKey) {
		return getChild().replaceChild(value, oldKey, newKey);
	}
	@Override
	public void replaceAllChildren(BiFunction<? super K, ? super V, ? extends V> function) {
		Objects.requireNonNull(function);
        forEachChild((k,v) -> {
            while(!replaceChild(k, v, function.apply(k, v))) {
                // v changed or k is gone
                if ( (v = getChild(k)) == null) {
                    // k is no longer in the map.
                    break;
                }
            }
        });
	}
	@Override
	public void replaceAllParents(BiFunction<? super V, ? super K, ? extends K> function) {
		getChild().replaceAllChildren(function);
	}
	@Override
	public boolean removeChild(K key, V value) {
		Object curValue = getChild(key);
		if (!Objects.equals(curValue, value) || (curValue == null && !containsParent(key))) {
			return false;
		}
		key.clear();
		return true;
	}
	@Override
	public boolean removeParent(V value, K key) {
		return getChild().removeChild(value, key);
	}
}