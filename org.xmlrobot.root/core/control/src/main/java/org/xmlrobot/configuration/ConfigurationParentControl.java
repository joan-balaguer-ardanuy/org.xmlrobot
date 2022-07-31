package org.xmlrobot.configuration;

import org.xmlrobot.ChildControl;
import org.xmlrobot.DataObject;
import org.xmlrobot.ObjectData;
import org.xmlrobot.ParentControl;

public class ConfigurationParentControl extends ParentControl {

	private static final long serialVersionUID = -2075224638986220550L;

	public ConfigurationParentControl() {
		super();
	}
	public ConfigurationParentControl(Configuration message) {
		super(message);
	}
	public ConfigurationParentControl(Class<ConfigurationChildControl> childClass, Configuration message, ParentControl key) {
		super(ConfigurationParentControl.class, childClass, message, key, new DataObject(ObjectData.class, message));
		addEventListener(key);
	}
	public ConfigurationParentControl(ParentControl parent, Configuration message) {
		super(parent, message);
	}
	public ConfigurationParentControl(Class<ConfigurationChildControl> childClass, ParentControl parent, Configuration message) {
		super(childClass, parent, message, new DataObject(ObjectData.class, message));
	}
	public ConfigurationParentControl(ParentControl root, ChildControl stem, Configuration message) {
		super(root, stem, message);
	}
	public ConfigurationParentControl(Class<ConfigurationChildControl> childClass, ParentControl root, ChildControl stem, Configuration message) {
		super(childClass, root, stem, message, new DataObject(ObjectData.class, message));
	}
}
