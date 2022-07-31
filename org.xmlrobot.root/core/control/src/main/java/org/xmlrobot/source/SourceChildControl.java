package org.xmlrobot.source;

import org.xmlrobot.ChildControl;
import org.xmlrobot.DataObject;
import org.xmlrobot.ObjectData;
import org.xmlrobot.ParentControl;
import org.xmlrobot.configuration.ConfigurationChildControl;
import org.xmlrobot.configuration.ConfigurationParentControl;
import org.xmlrobot.configuration.ConnectionChildControl;
import org.xmlrobot.configuration.ConnectionParentControl;

import jakarta.xml.bind.annotation.XmlElement;

public class SourceChildControl extends ChildControl {

	private static final long serialVersionUID = -7603305064113753801L;

	@XmlElement
	public ConnectionChildControl getConnectionControl() {
		for(ChildControl control : getOutput()) {
			if(control instanceof ConnectionChildControl) {
				return (ConnectionChildControl) control;
			}
		}
		return null;
	}
	@XmlElement
	public ConfigurationChildControl getConfigurationControl() {
		for(ChildControl control : getOutput()) {
			if(control instanceof ConfigurationChildControl) {
				return (ConfigurationChildControl) control;
			}
		}
		return null;
	}
	
	public SourceChildControl() {
		super();
	}
	public SourceChildControl(Source message) {
		super(message);
	}
	public SourceChildControl(Class<? extends ChildControl> parentClass, Class<? extends ParentControl> childClass, Source message) {
		super(parentClass, childClass, message, null, new ObjectData(DataObject.class, message));
	}
	public SourceChildControl(ChildControl parent, Source message) {
		super(parent, message);
	}
	public SourceChildControl(Class<? extends ParentControl> childClass, ChildControl parent, Source message) {
		super(childClass, parent, message, new ObjectData(DataObject.class, message));
	}
	public SourceChildControl(ChildControl root, ParentControl stem, Source message) {
		super(root, stem, message);
	}
	public SourceChildControl(Class<? extends ParentControl> childClass, ChildControl root, ParentControl stem, Source message) {
		super(childClass, root, stem, message, new ObjectData(DataObject.class, message));
	}
}
