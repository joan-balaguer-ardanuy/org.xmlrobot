package org.xmlrobot;

import hyperspace.recurrent.Hypermap;

public class ParentEntry<K,V> extends Parent {

	private static final long serialVersionUID = 3687888789355724893L;

	Control control;
	Hypermap<K,V> data;
	
	public ParentEntry() {
		super();
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, String name) {
		super(type, name);
	}
	public ParentEntry(Class<? extends ParentEntry<K,V>> type, Control control, Parent input) {
		super(type, control.getXml(), input);
		this.control = control;
	}
	public ParentEntry(ParentEntry<K,V> parent) {
		super(parent);
	}
	public ParentEntry(ParentEntry<K,V> parent, K key, V value, Parent input) {
		super(parent, input);
		this.control = parent.control;
	}
	public ParentEntry(ParentEntry<K,V> root, String name) {
		super(root, name);
	}
	public ParentEntry(ParentEntry<K,V> root, String name, K key, V value, Parent input) {
		super(root, name, input);
		this.control = root.control;
	}
}