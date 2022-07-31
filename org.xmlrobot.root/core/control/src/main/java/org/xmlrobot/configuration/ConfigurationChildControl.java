package org.xmlrobot.configuration;

import org.xmlrobot.ChildControl;
import org.xmlrobot.DataObject;
import org.xmlrobot.ObjectData;
import org.xmlrobot.ParentControl;

public class ConfigurationChildControl extends ChildControl {

	private static final long serialVersionUID = 2389283179826660667L;

	public ConfigurationChildControl() {
		super();
	}
	public ConfigurationChildControl(Configuration message) {
		super(message);
	}
	public ConfigurationChildControl(Class<ConfigurationParentControl> childClass, Configuration message, ChildControl key) {
		super(ConfigurationChildControl.class, childClass, message, key, new ObjectData(DataObject.class, message));
	}
	public ConfigurationChildControl(ChildControl parent, Configuration message) {
		super(parent, message);
	}
	public ConfigurationChildControl(Class<ConfigurationParentControl> childClass, ChildControl parent, Configuration message) {
		super(childClass, parent, message, new ObjectData(DataObject.class, message));
	}
	public ConfigurationChildControl(ChildControl root, ParentControl stem, Configuration message) {
		super(root, stem, message);
	}
	public ConfigurationChildControl(Class<ConfigurationParentControl> childClass, ChildControl root, ParentControl stem, Configuration message) {
		super(childClass, root, stem, message, new ObjectData(DataObject.class, message));
	}
}