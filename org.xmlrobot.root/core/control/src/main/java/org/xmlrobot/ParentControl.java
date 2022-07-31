package org.xmlrobot;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import hyperspace.XML;
import hyperspace.genesis.DNA;

public class ParentControl extends XML2<ParentControl,ChildControl> implements Map<Data, Object> {

	private static final long serialVersionUID = -8735445195576976969L;

	DNA<Data,Object> map;

	public DNA<Data, Object> getMap() {
		return map;
	}
	public void setMap(DNA<Data, Object> map) {
		this.map = map;
	}

	@Override
	public Data getKey() {
		return map.getKey();
	}
	@Override
	public Data setKey(Data key) {
		return map.setKey(key);
	}	@Override
	public Object getValue() {
		return map.getValue();
	}
	@Override
	public Object setValue(Object value) {
		return map.setValue(value);
	}

	public ParentControl() {
		super();
	}
	public ParentControl(XML message) {
		super(message, new ParentControlCollection(ParentControlCollection.class, message));
	}
	public ParentControl(Class<? extends ParentControl> parentClass, Class<? extends ChildControl> childClass, XML message, ParentControl key, DNA<Data,Object> map) {
		super(parentClass, childClass, message, key, new ParentControlCollection(ParentControlCollection.class, message));
		setMap(map);
		getChild().setSet(map.entryChain());
	}
	public ParentControl(ParentControl parent, XML message) {
		super(parent, message, new ParentControlCollection(ParentControlCollection.class, message));
	}
	public ParentControl(Class<? extends ChildControl> childClass, ParentControl parent, XML message, DNA<Data,Object> map) {
		super(childClass, parent, message, new ParentControlCollection(ParentControlCollection.class, message));
		setMap(map);
		getChild().setSet(map.entryChain());
	}
	public ParentControl(ParentControl root, ChildControl stem, XML message) {
		super(root, stem, message, new ParentControlCollection(ParentControlCollection.class, message));
	}
	public ParentControl(Class<? extends ChildControl> childClass, ParentControl root, ChildControl stem, XML message, DNA<Data,Object> map) {
		super(childClass, root, stem, message, new ParentControlCollection(ParentControlCollection.class, message));
		setMap(map);
		getChild().setSet(map.entryChain());
	}

	@Override
	@Deprecated
	public int size() {
		return 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	@Override
	public Object put(Data key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(java.util.Map<? extends Data, ? extends Object> m) {
		map.putAll(m);
	}

	@Override
	public Set<Data> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<Object> values() {
		return map.values();
	}

	@Override
	public Set<Entry<Data, Object>> entrySet() {
		return map.entrySet();
	}

	@Override
	public Iterator<Data> iterator() {
		return map.iterator();
	}
}
