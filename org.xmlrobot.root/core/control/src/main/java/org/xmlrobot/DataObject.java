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
	public DataObject(DataObject parent, XML message) {
		super(parent, message);
	}
	public DataObject(Class<ObjectData> childClass, DataObject parent, XML message, Data key, Object value) {
		super(childClass, parent, message, key, value);
	}
	public DataObject(DataObject root, ObjectData stem, XML message) {
		super(root, stem, message);
	}
	public DataObject(Class<ObjectData> childClass, DataObject root, ObjectData stem, XML message, Data key, Object value) {
		super(childClass, root, stem, message, key, value);
	}
}