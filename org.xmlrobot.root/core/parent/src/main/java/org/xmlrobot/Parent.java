package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.List;

public class Parent extends XML2<Parent> {

	private static final long serialVersionUID = -1212960878410135238L;

	public Parent() {
		super();
	}
	public Parent(Class<? extends Robot<Parent>> type, String name) {
		super(type, name);
	}
	public Parent(Class<? extends Robot<Parent>> type, Message xml, Parent input, List<Parent> output) {
		super(type, xml, input, output);
	}
	public Parent(Robot<Parent> parent) {
		super(parent);
	}
	public Parent(Robot<Parent> parent, Parent input, List<Parent> output) {
		super(parent, input, output);
	}
	public Parent(Robot<Parent> root, String name) {
		super(root, name);
	}
	public Parent(Robot<Parent> root, String name, Parent input, List<Parent> output) {
		super(root, name, input, output);
	}
}