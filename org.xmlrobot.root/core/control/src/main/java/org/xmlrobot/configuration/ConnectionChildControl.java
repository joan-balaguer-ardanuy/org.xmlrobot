package org.xmlrobot.configuration;

import org.xmlrobot.ChildControl;
import org.xmlrobot.DataObject;
import org.xmlrobot.ObjectData;
import org.xmlrobot.ParentControl;

import hyperspace.XML;

public class ConnectionChildControl extends ChildControl {

	private static final long serialVersionUID = -1152181904842295689L;

	public ConnectionChildControl() {
		super();
	}
	public ConnectionChildControl(XML message) {
		super(message);
	}
	public ConnectionChildControl(Class<? extends ChildControl> parentClass, Class<? extends ParentControl> childClass, XML message, ChildControl key) {
		super(parentClass, childClass, message, key,  new ObjectData(DataObject.class, message));
	}
	public ConnectionChildControl(ChildControl parent, XML message) {
		super(parent, message);
	}
	public ConnectionChildControl(Class<? extends ParentControl> childClass, ChildControl parent, XML message) {
		super(childClass, parent, message, new ObjectData(DataObject.class, message));
	}
	public ConnectionChildControl(ChildControl root, ParentControl stem, XML message) {
		super(root, stem, message);
	}
	public ConnectionChildControl(Class<? extends ParentControl> childClass, ChildControl root, ParentControl stem, XML message) {
		super(childClass, root, stem, message, new ObjectData(DataObject.class, message));
	}
}
