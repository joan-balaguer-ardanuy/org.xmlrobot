package org.xmlrobot;

import hyperspace.recurrent.AbstractList;

public class ControlList extends AbstractList<Control> {

	private static final long serialVersionUID = -5758067041921967026L;

	public ControlList() {
		super();
	}
	public ControlList(String name) {
		super(name);
	}
	public ControlList(Class<ControlList> antitype, String name) {
		super(ControlList.class, antitype, name, null);
	}
	public ControlList(ControlList parent) {
		super(parent);
	}
	public ControlList(Class<ControlList> antitype, ControlList parent, Control element) {
		super(antitype, parent, element);
	}
	public ControlList(ControlList root, String name) {
		super(root, name);
	}
	public ControlList(Class<ControlList> antitype, ControlList root, String name, Control element) {
		super(antitype, root, name, element);
	}
	
}