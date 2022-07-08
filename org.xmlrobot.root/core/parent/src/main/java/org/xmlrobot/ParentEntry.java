package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.Hypermap;
import hyperspace.recurrent.List;

public class ParentEntry<K,V> extends Parent {

	private static final long serialVersionUID = 3687888789355724893L;

	Control control;
	Hypermap<K, V> data;
	
	public ParentEntry() {
		super();
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, String name) {
		super(type, name);
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, Class<? extends Control> controlType, Message xml, Parent input, List<Parent> output) {
		super(type, xml, input, output);
		control = instance(controlType, xml);
	}
	public ParentEntry(ParentEntry<K,V> parent) {
		super(parent);
	}
	public ParentEntry(ParentEntry<K,V> parent, K key, V value, Parent input, List<Parent> output) {
		super(parent, input, output);
	}
	public ParentEntry(ParentEntry<K,V> root, String name) {
		super(root, name);
	}
	public ParentEntry(ParentEntry<K,V> root, String name, K key, V value, Parent input, List<Parent> output) {
		super(root, name, input, output);
	}
}