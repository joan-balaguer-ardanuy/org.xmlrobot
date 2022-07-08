/**
 * 
 */
package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.List;

/**
 * @author joan
 *
 */
public class Control
	extends XML2<Control> {

	private static final long serialVersionUID = -3218428113375546278L;
	
	public Control() {
		super();
	}
	public Control(Class<? extends Robot<Control>> type, String name) {
		super(type, name);
	}
	public Control(Class<? extends Robot<Control>> type, Message xml, Control input, List<Control> output) {
		super(type, xml, input, output);
	}
	public Control(Robot<Control> parent) {
		super(parent);
	}
	public Control(Robot<Control> parent, Control input, List<Control> output) {
		super(parent, input, output);
	}
	public Control(Robot<Control> root, String name) {
		super(root, name);
	}
	public Control(Robot<Control> root, String name, Control input, List<Control> output) {
		super(root, name, input, output);
	}
}