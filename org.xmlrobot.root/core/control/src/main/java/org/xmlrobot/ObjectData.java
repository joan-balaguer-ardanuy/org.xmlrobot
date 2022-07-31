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
	public ObjectData(ObjectData parent, XML message) {
		super(parent, message);
	}
	public ObjectData(Class<DataObject> childClass, ObjectData parent, XML message, Object key, Data value) {
		super(childClass, parent, message, key, value);
	}
	public ObjectData(ObjectData root, DataObject stem, XML message) {
		super(root, stem, message);
	}
	public ObjectData(Class<DataObject> childClass, ObjectData root, DataObject stem, XML message, Object key, Data value) {
		super(childClass, root, stem, message, key, value);
	}
}