package org.xmlrobot;

import hyperspace.recurrent.Hypermap;

public class DataObject extends Hypermap<Data,Object> {

	private static final long serialVersionUID = 7038694420645381542L;
	
	public DataObject() {
		super();
	}
	public DataObject(String name) {
		super(name);
	}
	public DataObject(Class<DataObject> type, String name) {
		super(type, name);
	}
	public DataObject(DataObject parent) {
		super(parent);
	}
	public DataObject(DataObject parent, Data key, Object value) {
		super(parent, key, value);
	}
	public DataObject(DataObject root, String name) {
		super(root, name);
	}
	public DataObject(DataObject root, String name, Data key, Object value) {
		super(root, name, key, value);
	}	
}