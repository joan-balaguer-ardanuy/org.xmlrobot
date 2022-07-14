package org.xmlrobot;

import hyperspace.recurrent.Hyperlist;
import hyperspace.recurrent.List;

public class ParentList extends Hyperlist<Parent> {

	private static final long serialVersionUID = -1376445567413764127L;

	public ParentList() {
	}
	public ParentList(String name) {
		super(name);
	}
	public ParentList(Class<? extends List<Parent>> antitype, String name) {
		super(ParentList.class, antitype, name, null);
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> parent, Parent element) {
		super(antitype, parent, element);
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> root, String name, Parent element) {
		super(antitype, root, name, element);
	}
	public ParentList(List<Parent> root, String name) {
		super(root, name);
	}
	public ParentList(List<Parent> parent) {
		super(parent);
	}
}
