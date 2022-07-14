package org.xmlrobot;

import hyperspace.recurrent.Hypercollection;

public class ControlCollection extends Hypercollection<Control> {

	private static final long serialVersionUID = -5758067041921967026L;
	
	public ControlCollection() {
		super();
	}
	public ControlCollection(String name) {
		super(name);
	}
	public ControlCollection(Class<ControlCollection> childClass, String name) {
		super(ControlCollection.class, childClass, name, null);
	}
	public ControlCollection(ControlCollection parent) {
		super(parent);
	}
	public ControlCollection(Class<ControlCollection> childClass, ControlCollection parent, Control element) {
		super(childClass, parent, element);
	}
	public ControlCollection(ControlCollection root, String name) {
		super(root, name);
	}
	public ControlCollection(Class<ControlCollection> childClass, ControlCollection root, String name, Control element) {
		super(childClass, root, name, element);
	}
	
}