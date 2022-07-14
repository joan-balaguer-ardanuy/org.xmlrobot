package org.xmlrobot;

import hyperspace.recurrent.Hypermap;

public class ParentEntry<K,V> extends Parent {

	private static final long serialVersionUID = 3687888789355724893L;

	ParentControl control;
	Hypermap<K,V> data;
	
	public ParentEntry() {
		super();
	}
}