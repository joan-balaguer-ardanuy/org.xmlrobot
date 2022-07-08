package org.xmlrobot;

import hyperspace.Message;

public abstract class Parent extends XML2<Parent> {

	private static final long serialVersionUID = -1212960878410135238L;

	public Parent() {
		super();
	}
	public Parent(Class<? extends Parent> type, String name) {
		super(type, name);
	}
	public Parent(Class<? extends Parent> type, Message xml, Parent input) {
		super(type, xml, input, new ParentList(ParentList.class, xml.getName()));
	}
	public Parent(Parent parent) {
		super(parent);
	}
	public Parent(Parent parent, Parent input) {
		super(parent, input, new ParentList(ParentList.class, parent.getName()));
	}
	public Parent(Parent root, String name) {
		super(root, name);
	}
	public Parent(Parent root, String name, Parent input) {
		super(root, name, input, new ParentList(ParentList.class, root.getName()));
	}
}