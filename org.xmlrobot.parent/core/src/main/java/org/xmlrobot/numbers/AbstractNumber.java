package org.xmlrobot.numbers;

import java.io.Serializable;

public class AbstractNumber<K extends Number<K>>
	implements Number<K>, Serializable {
	
	private static final long serialVersionUID = -2189724676292955895L;

	K root;
	
	K parent;
	
	K past;

	@Override
	public K getRoot() {
		return root;
	}
	@Override
	public K setRoot(K root) {
		K old = this.root;
		this.root = root;
		return old;
	}
	
	@Override
	public K getParent() {
		return parent;
	}
	@Override
	public K setParent(K parent) {
		K old = this.parent;
		this.parent = parent;
		return old;
	}
	
	@Override
	public K call() {
		return this.past;
	}
	@Override
	public K put(K key) {
		K old = this.past;
		this.past = key;
		return old;
	}
	
	@SuppressWarnings("unchecked")
	public AbstractNumber() {
		root = parent = past = (K) this;
	}
	
	@SuppressWarnings("unchecked")
	public AbstractNumber(K parent) {
		setParent(parent);
		put(parent.call());
		parent.call().setParent((K) this);
		parent.put(parent.call().getParent());
		setRoot(parent.getRoot());
	}
	
	@Override
	public boolean isEmpty() {
		return getParent() == this;
	}
	
	@SuppressWarnings("unchecked")
	public void recur(K parent) {
		parent.setParent(getParent());
		parent.put((K) this);
		getParent().put(parent);
		setParent(parent);
	}
	
	@SuppressWarnings("unchecked")
	public void concur(K parent) {
		parent.setParent((K) this);
		parent.put(call());
		call().setParent(parent);
		put(parent);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void release() {
		getParent().put(call());
		call().setParent(getParent());
		this.parent = this.past = (K) this;
	}
	
	@Override
	public boolean hasParent(K parent) {
		Enumerator<K> en = enumerator();
		while(en.hasMoreElements())  {
			if(en.nextElement() == parent) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean releaseParent(K parent) {
		Enumerator<K> en = enumerator();
		while(en.hasMoreElements()) {
			if(en.nextElement() == parent) {
				en.remove();
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean addParent(K parent) {
		if(!hasParent(parent)) {
			recur(parent);
			return true;	
		} else return false;
	}
	@Override
	public boolean hasAllParents(K parent) {
		Enumerator<K> en = parent.enumerator();
		while(en.hasMoreElements())
			if(!hasParent(en.nextElement()))
				return false;
		return false;
	}
	@Override
	public boolean addAllParents(K parent) {
		boolean modified = false;
		Enumerator<K> en = parent.enumerator();
		while (en.hasMoreElements())
			if (addParent(en.nextElement()))
				modified = true;
		return modified;
	}
	@Override
	public boolean releaseAllParents(K parent) {
		boolean modified = false;
		Enumerator<K> en = enumerator();
        while (en.hasMoreElements()) {
            if (parent.hasParent(en.nextElement())) {
                en.remove();
                modified = true;
            }
        }
        return modified;
	}
	@Override
	public boolean retainAllParents(K parent) {
		boolean modified = false;
		Enumerator<K> en = enumerator();
		while (en.hasMoreElements()) {
			if (!parent.hasParent(en.nextElement())) {
				en.remove();
				modified = true;
			}
		}
		return modified;
	}
	@Override
	public Enumerator<K> enumerator() {
		return new ParentEnumerator(getParent());
	}
	protected final class ParentEnumerator implements Enumerator<K> {

		/**
		 * The current number.
		 */
		K current;

		/**
		 * The next number.
		 */
		K next;
		
		/**
		 * If this enumerator has next number.
		 */
		boolean hasNext;

		public ParentEnumerator(K parent) {
			next = current = parent;
			hasNext = true;
		}

		@Override
		public boolean hasMoreElements() {
			return hasNext;
		}
		@Override
		public K nextElement() {
			K c = next;
			current = c;
			next = c.getParent();
			if (c == AbstractNumber.this)
				hasNext = false;
			else
				hasNext = true;
			return c;
		}
		@Override
		public void remove() {
			K k = next;
			current.release();
			if (!k.isEmpty()) {
				current = k;
				next = k.getParent();
			} else
				hasNext = false;
		 }
	}
	/**
	 * Crea un objecte de classe X.
	 * @param <X> la classe de paràmetre de l'objecte retornat
	 * @param classe la classe del objecte retornat.
	 * @param arguments els arguments de la creació de l'objecte
	 * @return el nou objecte <X> creat
	 */
	protected static <X> X instance(Class<X> classe, Object... arguments) {
		try {
			return classe.getDeclaredConstructor(getClasses(arguments)).newInstance(arguments);
		}
		catch(Throwable t) {
			return null;
		}
	}
	/**
	 * Obté les classes dels objectes introduits com a arguments.
	 * @param objectes els objectes dels quals se'n vol obtenir les classes
	 * @return les classes dels objectes introduits com a arguments
	 */
	private static Class<?>[] getClasses(Object... objectes) {
		Class<?>[] classes = new Class<?>[objectes.length];
		for(int i = 0; i < objectes.length; i++) {
			classes[i] = objectes[i].getClass();
		}
		return classes;
	}
}