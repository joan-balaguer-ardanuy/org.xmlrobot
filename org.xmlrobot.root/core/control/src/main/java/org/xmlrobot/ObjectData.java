package org.xmlrobot;

import hyperspace.XML;
import hyperspace.genesis.Hyperchain;

public class ObjectData extends Hyperchain<Object,Data> {

	private static final long serialVersionUID = 5359589726361065625L;

	public ObjectData() {
		super();
	}
	public ObjectData(XML message) {
		super(message);
	}
	public ObjectData(Class<DataObject> childClass, XML message) {
		super(ObjectData.class, childClass, message);
	}
	public ObjectData(ObjectData parent) {
		super(parent);
	}
	public ObjectData(Class<DataObject> childClass, ObjectData parent, Object key, Data value) {
		super(childClass, parent, key, value);
	}
	public ObjectData(ObjectData root, XML message) {
		super(root, message);
	}
	public ObjectData(Class<DataObject> childClass, ObjectData root, XML message, Object key, Data value) {
		super(childClass, root, message, key, value);
	}
}