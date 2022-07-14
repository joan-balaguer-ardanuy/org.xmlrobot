/**
 * 
 */
package org.xmlrobot;

import hyperspace.Message;

/**
 * @author joan
 *
 */
public abstract class Control
	extends XML2<Control> {

	private static final long serialVersionUID = -3218428113375546278L;
	
	DataObject data;
	
	public Control() {
		super();
	}
	public Control(Class<? extends Control> type, String name) {
		super(type, name);
	}
	public Control(Class<? extends Control> type, Message xml, Control input) {
		super(type, xml, input, new ControlList(ControlList.class, xml.getName()));
	}
	public Control(Control parent) {
		super(parent);
	}
	public Control(Control parent, Control input) {
		super(parent, input, new ControlList(ControlList.class, parent.getName()));
	}
	public Control(Control root, String name) {
		super(root, name);
	}
	public Control(Control root, String name, Control input) {
		super(root, name, input, new ControlList(ControlList.class, root.getName()));
	}
}