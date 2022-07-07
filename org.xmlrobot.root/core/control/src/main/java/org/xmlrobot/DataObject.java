package org.xmlrobot;

import hyperspace.recurrent.Hypermap;
import hyperspace.recurrent.Map;

public class DataObject extends Hypermap<Data,Object> {

	private static final long serialVersionUID = 7038694420645381542L;
	
	public DataObject() {
		super();
	}
	public DataObject(Class<? extends Map<Data, Object>> type, String name) {
		super(type, name);
	}
	public DataObject(Class<? extends Map<Data, Object>> type, String name, Data key, Object value) {
		super(type, name, key, value);
	}
	public DataObject(Map<Data, Object> parent) {
		super(parent);
	}
	public DataObject(Map<Data, Object> parent, Data key, Object value) {
		super(parent, key, value);
	}
	public DataObject(Map<Data, Object> root, String name) {
		super(root, name);
	}
	public DataObject(Map<Data, Object> root, String name, Data key, Object value) {
		super(root, name, key, value);
	}	
}