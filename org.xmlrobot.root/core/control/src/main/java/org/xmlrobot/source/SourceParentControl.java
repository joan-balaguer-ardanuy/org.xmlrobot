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
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SourceParentControl extends ParentControl {

	private static final long serialVersionUID = -3524187914440363242L;

	@XmlElement
	public ConnectionParentControl getConnectionControl() {
		for(ParentControl control : getOutput()) {
			if(control instanceof ConnectionParentControl) {
				return (ConnectionParentControl) control;
			}
		}
		return null;
	}
	@XmlElement
	public ConfigurationParentControl getConfigurationControl() {
		for(ParentControl control : getOutput()) {
			if(control instanceof ConfigurationParentControl) {
				return (ConfigurationParentControl) control;
			}
		}
		return null;
	}

	public SourceParentControl() {
		super();
	}
	public SourceParentControl(Source message) {
		super(message);
	}
	public SourceParentControl(Class<SourceChildControl> childClass, Source message) {
		super(SourceParentControl.class, childClass, message, null, new DataObject(ObjectData.class, message));
		add(new ConnectionParentControl(ConnectionChildControl.class, message.getConnection(), this));
		add(new ConfigurationParentControl(ConfigurationChildControl.class, message.getConfiguration(), this));
	}
	public SourceParentControl(ParentControl parent, Source message) {
		super(parent, message);
	}
	public SourceParentControl(Class<SourceChildControl> childClass, ParentControl parent, Source message) {
		super(childClass, parent, message, new DataObject(ObjectData.class, message));
		add(new ConnectionParentControl(ConnectionChildControl.class, message.getConnection(), this));
		add(new ConfigurationParentControl(ConfigurationChildControl.class, message.getConfiguration(), this));
	}
	public SourceParentControl(ParentControl root, ChildControl stem, Source message) {
		super(root, stem, message);
	}
	public SourceParentControl(Class<SourceChildControl> childClass, ParentControl root, ChildControl stem, Source message) {
		super(childClass, root, stem, message, new DataObject(ObjectData.class, message));
		add(new ConnectionParentControl(ConnectionChildControl.class, message.getConnection(), this));
		add(new ConfigurationParentControl(ConfigurationChildControl.class, message.getConfiguration(), this));
	}
}
