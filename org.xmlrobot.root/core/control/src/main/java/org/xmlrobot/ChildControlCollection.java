package org.xmlrobot;

import hyperspace.XML;
import hyperspace.recurrent.Hypercollection;

public class ChildControlCollection extends Hypercollection<ChildControl> {

	private static final long serialVersionUID = 3367035919464426851L;

	public ChildControlCollection() {
	}
	public ChildControlCollection(XML message) {
		super(message);
	}
	public ChildControlCollection(Class<? extends ChildControlCollection> antitype, XML message) {
		super(ChildControlCollection.class, antitype, message);
	}
	public ChildControlCollection(Class<? extends ChildControlCollection> antitype, Hypercollection<ChildControl> root, Hypercollection<ChildControl> stem, XML message, ChildControl element) {
		super(antitype, root, stem, message, element);
	}
	public ChildControlCollection(Class<? extends ChildControlCollection> antitype, Hypercollection<ChildControl> parent, XML message, ChildControl element) {
		super(antitype, parent, message, element);
	}
	public ChildControlCollection(Hypercollection<ChildControl> root, Hypercollection<ChildControl> stem, XML message) {
		super(root, stem, message);
	}
	public ChildControlCollection(Hypercollection<ChildControl> parent, XML message) {
		super(parent, message);
	}

}
