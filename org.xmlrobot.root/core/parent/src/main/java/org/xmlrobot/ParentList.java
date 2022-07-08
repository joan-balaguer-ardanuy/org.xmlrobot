package org.xmlrobot;

import hyperspace.recurrent.AbstractList;
import hyperspace.recurrent.List;

public class ParentList extends AbstractList<Parent> {

	private static final long serialVersionUID = -1376445567413764127L;

	public ParentList() {
	}
	public ParentList(String name) {
		super(name);
	}
	public ParentList(Class<? extends List<Parent>> type, Class<? extends List<Parent>> antitype, String name,
			Parent element) {
		super(type, antitype, name, element);
		// TODO Auto-generated constructor stub
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> parent, Parent element) {
		super(antitype, parent, element);
		// TODO Auto-generated constructor stub
	}
	public ParentList(Class<? extends List<Parent>> antitype, List<Parent> root, String name, Parent element) {
		super(antitype, root, name, element);
		// TODO Auto-generated constructor stub
	}
	public ParentList(List<Parent> root, String name) {
		super(root, name);
		// TODO Auto-generated constructor stub
	}
	public ParentList(List<Parent> parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
}
