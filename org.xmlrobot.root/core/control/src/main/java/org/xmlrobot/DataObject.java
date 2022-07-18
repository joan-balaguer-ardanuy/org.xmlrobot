package org.xmlrobot;

import hyperspace.XML;
import hyperspace.genesis.Hypercube;

public class DataObject extends Hypercube<Data,Object> {

	private static final long serialVersionUID = 7038694420645381542L;
	
	public DataObject() {
		super();
	}
	public DataObject(XML message) {
		super(message);
	}
	public DataObject(Class<ObjectData> childClass, XML message) {
		super(DataObject.class, childClass, message);
	}
	public DataObject(DataObject parent) {
		super(parent);
	}
	public DataObject(Class<ObjectData> childClass, DataObject parent, Data key, Object value) {
		super(childClass, parent, key, value);
	}
	public DataObject(DataObject root, XML message) {
		super(root, message);
	}
	public DataObject(Class<ObjectData> childClass, DataObject root, XML message, Data key, Object value) {
		super(childClass, root, message, key, value);
	}
}