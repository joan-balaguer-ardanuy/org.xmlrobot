package org.xmlrobot;

import java.util.Collection;
import java.util.Iterator;

import hyperspace.Entry;
import hyperspace.XML;
import hyperspace.genesis.Chain;

public class ChildControl extends XML2<ChildControl,ParentControl> implements EntrySet<Object,Data> {

	private static final long serialVersionUID = -666554516027637756L;

	Chain<Object,Data> set;

	public Chain<Object,Data> getSet() {
		return set;
	}
	public void setSet(Chain<Object,Data> set) {
		this.set = set;
	}

	@Override
	public Object getKey() {
		return set.getKey();
	}
	@Override
	public Object setKey(Object key) {
		return set.setKey(key);
	}
	@Override
	public Data getValue() {
		return set.getValue();
	}
	@Override
	public Data setValue(Data value) {
		return set.setValue(value);
	}
	
	public ChildControl() {
		super();
	}
	public ChildControl(XML message) {
		super(message, new ChildControlCollection(ChildControlCollection.class, message));
	}
	public ChildControl(Class<? extends ChildControl> parentClass, Class<? extends ParentControl> childClass, XML message, ChildControl key, Chain<Object,Data> set) {
		super(parentClass, childClass, message, key, new ChildControlCollection(ChildControlCollection.class, message));
		setSet(set);
		getChild().setMap(set.entryDNA());
	}
	public ChildControl(ChildControl parent, XML message) {
		super(parent, message, new ChildControlCollection(ChildControlCollection.class, message));
	}
	public ChildControl(Class<? extends ParentControl> childClass, ChildControl parent, XML message, Chain<Object,Data> set) {
		super(childClass, parent, message, new ChildControlCollection(ChildControlCollection.class, message));
		setSet(set);
		getChild().setMap(set.entryDNA());
	}
	public ChildControl(ChildControl root, ParentControl stem, XML message) {
		super(root, stem, message, new ChildControlCollection(ChildControlCollection.class, message));
	}
	public ChildControl(Class<? extends ParentControl> childClass, ChildControl root, ParentControl stem, XML message, Chain<Object,Data> set) {
		super(childClass, root, stem, message, new ChildControlCollection(ChildControlCollection.class, message));
		setSet(set);
		getChild().setMap(set.entryDNA());
	}
	@Override
	@Deprecated
	public int size() {
		return 0;
	}
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}
	@Override
	public Iterator<Entry<Object, Data>> iterator() {
		return set.iterator();
	}
	@Override
	@Deprecated
	public Object[] toArray() {
		return null;
	}
	@Override
	@Deprecated
	public <T> T[] toArray(T[] a) {
		return null;
	}
	@Override
	public boolean add(Entry<Object, Data> e) {
		return set.add(e);
	}
	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}
	@Override
	public boolean addAll(Collection<? extends Entry<Object, Data>> c) {
		return set.addAll(c);
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}
	@Override
	public Data put(Object key, Data value) {
		return set.putValue(key, value);
	}
}
