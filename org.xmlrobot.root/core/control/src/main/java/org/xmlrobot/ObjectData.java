package org.xmlrobot;

import hyperspace.genesis.Hyperchain;

public class ObjectData extends Hyperchain<Object,Data> {

	private static final long serialVersionUID = 5359589726361065625L;

	public ObjectData() {
		super();
	}
	public ObjectData(String name, Object key) {
		super(ObjectData.class, name, key);
	}
	public ObjectData(Class<ObjectData> antitype, String name, Object key, Data value) {
		super(antitype, DataObject.class, name, key, value);
	}
	public ObjectData(ObjectData parent, Object key) {
		super(parent, key);
	}
	public ObjectData(Class<DataObject> antitype, ObjectData parent, Object key, Data value) {
		super(antitype, parent, key, value);
	}
	public ObjectData(ObjectData root, String name, Object key) {
		super(root, name, key);
	}
	public ObjectData(Class<DataObject> antitype, ObjectData root, String name, Object key, Data value) {
		super(antitype, root, name, key, value);
	}
}