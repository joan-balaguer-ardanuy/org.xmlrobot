package org.xmlrobot;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import hyperspace.XML;
import hyperspace.time.Time;

public class XML2<K extends XML2<K,V>,V extends XML2<V,K>> 
	extends Time<K,V> 
		implements Robot<K,java.util.Collection<K>> {
	
	private static final long serialVersionUID = 2706435796117163607L;
	
	K key;
	java.util.Collection<K> value;
	
	@Override
	public K getInput() {
		return key;
	}
	public K setInput(K key) {
		K old = this.key;
		this.key = key;
		return old;
	}
	@Override
	public java.util.Collection<K> getOutput() {
		return value;
	}
	@Override
	public java.util.Collection<K> setOutput(java.util.Collection<K> value) {
		java.util.Collection<K> old = this.value;
		this.value  = value;
		return old;
	}
	
	public XML2() {
	}
	public XML2(XML message, java.util.Collection<K> value) {
		super(message);
		setOutput(value);
	}
	public XML2(Class<? extends K> parentClass, Class<? extends V> childClass, XML message, K key, java.util.Collection<K> value) {
		super(parentClass, childClass, message);
		setInput(key == null ? parentClass.cast(this) : key);
		setOutput(value);
		getChild().setInput(key != null ? key.getChild() : null);
	}
	public XML2(K parent, XML message, java.util.Collection<K> value) {
		super(parent, message);
		setInput(parent);
		setOutput(value);
	}
	public XML2(Class<? extends V> childClass, K parent, XML message, java.util.Collection<K> value) {
		super(childClass, parent, message);
		setInput(parent);
		setOutput(value);
	}
	public XML2(K root, V stem, XML message, java.util.Collection<K> value) {
		super(root, stem, message);
		setInput(root.getInput());
		setOutput(value);
	}
	public XML2(Class<? extends V> childClass, K root, V stem, XML message, java.util.Collection<K> value) {
		super(childClass, root, stem, message);
		setInput(root.getInput());
		setOutput(value);
	}
	
	@Override
	public Transmitter<K,V> comparator(K source) {
		return null;
	}

	@Override
	public Transmitter<K,V> comparator() {
		return null;
	}

	public void start() {
		for(K value : getOutput()) {
			value.start();
		}
	}
	public void stop() {
		for(K value : getOutput()) {
			value.stop();
		}
	}
	public void add(K key) {
		getOutput().add(key);
		getChild().getOutput().add(key.getChild());
	}
}
