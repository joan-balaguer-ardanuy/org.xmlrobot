package org.xmlrobot;

import hyperspace.XML;
import hyperspace.recurrent.Hyperlist;
import hyperspace.recurrent.List;

public class ParentList extends Hyperlist<Parent> {

	private static final long serialVersionUID = -1376445567413764127L;

	public ParentList() {
	}
	public ParentList(XML name) {
		super(name);
	}
	public ParentList(Class<? extends List<Parent>> antitype, XML name) {
		super(ParentList.class, antitype, name);
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> parent, Parent element) {
		super(antitype, parent, element);
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> root, XML name, Parent element) {
		super(antitype, root, name, element);
	}
	public ParentList(List<Parent> root, XML name) {
		super(root, name);
	}
	public ParentList(List<Parent> parent) {
		super(parent);
	}
}
