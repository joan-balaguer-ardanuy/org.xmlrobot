package org.xmlrobot;

import hyperspace.recurrent.Map;

public abstract class ParentControl 
	extends XML2<ParentControl,ChildControl> {

	private static final long serialVersionUID = -6986427437237528455L;

	Map<Data,Object> data;
	
	public ParentControl() {
		super();
	}
	public ParentControl(String name) {
		super(name);
	}
	public ParentControl(Class<ParentControl> parentClass, Class<ChildControl> childClass, String name, ParentControl key, ChildControl value) {
		super(parentClass, childClass, name, key, value);
		addEventListener(key);
		data = new DataObject(DataObject.class, name);
		data.put(Data.KEY, key);
		data.put(Data.VALUE, getValue());
		
	}
	
	public Map<Data,Object> data() {
		return data;
	}
}
