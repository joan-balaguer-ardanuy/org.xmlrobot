package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.Hyperlist;
import hyperspace.recurrent.Hypermap;
import hyperspace.recurrent.Map;

public class XML2<K,V,T extends Robot<T>>
	extends Hyperlist<T>
		implements Robot<T> {

	private static final long serialVersionUID = 2893001885051512991L;
	
	int index = 0;
	Message xml;
	Map<K,V> data;
	
	public XML2() {
		super();
	}
	public XML2(Class<? extends Robot<T>> type, String name) {
		super(type, name);
	}
	public XML2(Class<? extends Robot<T>> type, Class<? extends Hypermap<K,V>> mapType, Message xml, T input) {
		super(type, xml.getName(), input);
		data = instance(mapType, mapType);
	}
	public XML2(Robot<T> parent) {
		super(parent);
	}
	public XML2(Robot<T> parent, T input) {
		super(parent, input);
	}
	public XML2(Robot<T> root, String name, T input) {
		super(root, name, input);
	}
	public XML2(Robot<T> root, String name) {
		super(root, name);
	}
	@Override
	public void start() {
		for(T xml : getValue()) {
			xml.start();
		}
		reset();
	}
	@Override
	public void stop() {
		for(T xml : getValue()) {
			xml.stop();
		}
		reset();
	}
	@Override
	public void reset() {
		index = 0;
	}
	@Override
	public boolean hasNext() {
		return index < getValue().size();
	}
	@Override
	public T next() {
		T child = getValue().get(index);
		index++;
		return child;
	}
}