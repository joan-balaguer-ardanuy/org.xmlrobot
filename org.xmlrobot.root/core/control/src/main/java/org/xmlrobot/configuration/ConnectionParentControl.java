package org.xmlrobot.configuration;

import org.xmlrobot.ChildControl;
import org.xmlrobot.DataObject;
import org.xmlrobot.ObjectData;
import org.xmlrobot.ParentControl;

public class ConnectionParentControl extends ParentControl {

	private static final long serialVersionUID = -5682205881861262102L;

	public ConnectionParentControl() {
		super();
	}
	public ConnectionParentControl(Connection message) {
		super(message);
	}
	public ConnectionParentControl(Class<ConnectionChildControl> childClass, Connection message, ParentControl key) {
		super(ConnectionParentControl.class, childClass, message, key, new DataObject(ObjectData.class, message));
	}
	public ConnectionParentControl(ParentControl parent, Connection message) {
		super(parent, message);
	}
	public ConnectionParentControl(Class<ConnectionChildControl> childClass, ParentControl parent, Connection message) {
		super(childClass, parent, message, new DataObject(ObjectData.class, message));
	}
	public ConnectionParentControl(ParentControl root, ChildControl stem, Connection message) {
		super(root, stem, message);
	}
	public ConnectionParentControl(Class<ConnectionChildControl> childClass, ParentControl root, ChildControl stem, Connection message) {
		super(childClass, root, stem, message, new DataObject(ObjectData.class, message));
	}
}
