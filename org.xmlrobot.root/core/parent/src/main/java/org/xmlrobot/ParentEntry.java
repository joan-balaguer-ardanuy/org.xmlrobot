package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.Hypermap;

public class ParentEntry<K,V> extends Hypermap<K,V> {

	private static final long serialVersionUID = 3687888789355724893L;

	ParentControl control;
	Message xml;
	
	public ParentEntry() {
		super();
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, String name) {
		super(type, name);
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, Class<? extends ParentControl> controlType, Message xml) {
		super(type, xml.getName(), null, null);
		control = instance(controlType, xml);
	}
	public ParentEntry(ParentEntry<K,V> parent) {
		super(parent);
	}
	public ParentEntry(ParentEntry<K,V> parent, K key, V value) {
		super(parent, key, value);
	}
	public ParentEntry(ParentEntry<K,V> root, String name) {
		super(root, name);
	}
	public ParentEntry(ParentEntry<K,V> root, String name, K key, V value) {
		super(root, name, key, value);
	}
}