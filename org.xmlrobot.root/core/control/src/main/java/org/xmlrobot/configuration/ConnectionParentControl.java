package org.xmlrobot.configuration;

import org.xmlrobot.ChildControl;
import org.xmlrobot.Data;
import org.xmlrobot.EventType;
import org.xmlrobot.ParentControl;

import hyperspace.EventArgs;

public class ConnectionParentControl extends ParentControl {

	private static final long serialVersionUID = 3438328001383638980L;

	public ConnectionParentControl() {
		super();
	}
	public ConnectionParentControl(Connection message) {
		super(message);
	}
	public ConnectionParentControl(Class<? extends ParentControl> parentClass, Class<? extends ChildControl> childClass, Connection message) {
		super(parentClass, childClass, message);
	}
	public ConnectionParentControl(ParentControl parent) {
		super(parent);
	}
	public ConnectionParentControl(Class<? extends ChildControl> childClass, ParentControl parent, ParentControl key, ChildControl value) {
		super(childClass, parent, key, value);
	}
	public ConnectionParentControl(ParentControl root, Connection message) {
		super(root, message);
	}
	public ConnectionParentControl(Class<? extends ChildControl> childClass, ParentControl root, Connection message, ParentControl key, ChildControl value) {
		super(childClass, root, message, key, value);
	}

	@Override
	public void event(EventArgs e) {
		super.event(e);
		switch (e.getCommand()) {
		case EventType.STARTED:
			if(e.getSource() instanceof ConnectionParentControl) {
				ConnectionParentControl control = (ConnectionParentControl) e.getSource();
				Connection connection = (Connection) e.getMessage();
				control.putOutput(Data.Q_NAME, connection.getQName());
				control.putOutput(Data.URL, connection.getURL());
			}
			break;

		default:
			break;
		}
	}
}
