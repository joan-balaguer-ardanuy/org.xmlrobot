/**
 * 
 */
package org.xmlrobot;

import hyperspace.Message;

/**
 * @author joan
 *
 */
public class ParentControl
	extends XML2<Data,Object,ParentControl> {

	private static final long serialVersionUID = -3218428113375546278L;
	
	Message xml;
	
	public ParentControl() {
		super();
	}
	public ParentControl(Class<? extends Robot<ParentControl>> type, String name) {
		super(type, name);
	}
	public ParentControl(Class<? extends Robot<ParentControl>> type, Message xml, ParentControl input) {
		super(type, null, xml.getName(), input);
		this.xml = xml;
	}
	public ParentControl(Robot<ParentControl> parent) {
		super(parent);
	}
	public ParentControl(Robot<ParentControl> parent, ParentControl input) {
		super(parent, input);
	}
	public ParentControl(Robot<ParentControl> root, String name) {
		super(root, name);
	}
	public ParentControl(Robot<ParentControl> root, String name, ParentControl input) {
		super(root, name, input);
	}
}